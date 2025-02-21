package com.project.mallbydh.order;

import com.project.mallbydh.cart.CartService;
import com.project.mallbydh.cart.CartVO;
import com.project.mallbydh.member.MemberService;
import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Controller
public class OrderController {

    private final OrderService orderService;
    private final CartService cartService;
    private final MemberService memberService;

    @Value("${com.project.mallbydh.upload.path}")
    private String uploadPath;

    @GetMapping("/order_form")
    public String orderForm(@RequestParam(required = false) Integer prod_id,
                            @RequestParam(required = false) Integer cart_amount,
                            @RequestParam(required = false) List<Integer> prod_ids,
                            @RequestParam(required = false) Boolean mergeCart, String type, HttpSession session, Model model) {

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        List<Map<String, Object>> orderCartDetails;

        if(type.equals("direct")) {
            // 상품페이지에서 주문 버튼 클릭 시
            // 장바구니에 해당 상품이 이미 있는지 확인
            List<Map<String, Object>> existingItem = cartService.getCartDetailsByProdId(prod_id, u_id);

            if(!existingItem.isEmpty()) {
                if(mergeCart != null && mergeCart) {
                    // 기존 장바구니 항목과 병합
                    int existingAmount = ((Number) existingItem.get(0).get("cart_amount")).intValue();
                    int newAmount = existingAmount + cart_amount;
                    cartService.cartUpdate(newAmount, prod_id, u_id);
                } else {
                    // 새로운 수량으로 업데이트
                    cartService.cartUpdate(cart_amount, prod_id, u_id);
                }
            } else {
                // 새 항목 추가
                CartVO newItem = new CartVO();
                newItem.setU_id(u_id);
                newItem.setProd_id(prod_id);
                newItem.setCart_amount(cart_amount);
                cartService.cart_add(newItem);
            }
            orderCartDetails = cartService.getCartDetailsByProdId(prod_id, u_id);
        } else if(type.equals("selected")) {
            // 장바구니에서 선택 상품 주문 시
            orderCartDetails = cartService.getCartDetailsByProdIds(prod_ids, u_id);
        } else {
            // 장바구니 상품 전체 주문
            orderCartDetails = cartService.getCartDetailsByUserId(u_id);
        }

        // 상품 정보 - 사진 업로드 경로의 역슬래시를 슬래시로 변경
        orderCartDetails.forEach(cartVO -> {
            cartVO.put("prod_uploadfolder", cartVO.get("prod_uploadfolder").toString().replace("\\", "/"));
        });

        model.addAttribute("orderCartDetails", orderCartDetails);

        // 주문 정보의 총 수량, 총 금액 계산
        int totalQuantity = cartService.calculateTotalQuantity(orderCartDetails);
        model.addAttribute("totalQuantity", totalQuantity);
        int totalAmount = cartService.calculateTotalAmount(orderCartDetails);
        model.addAttribute("totalAmount", totalAmount);

        // 로그인한 사용자 정보
        MemberVO memberVO = memberService.modifyView(u_id);
        model.addAttribute("memberVO", memberVO);

        return "order/order_form";
    }

    @GetMapping("/check_cart")
    @ResponseBody
    public Map<String, Integer> checkCart(@RequestParam Integer prod_id,
                                          @RequestParam Integer cart_amount,
                                          HttpSession session) {
        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        List<Map<String, Object>> existingItem = cartService.getCartDetailsByProdId(prod_id, u_id);

        Map<String, Integer> response = new HashMap<>();
        if (!existingItem.isEmpty()) {
            response.put("existingAmount", ((Number)existingItem.get(0).get("cart_amount")).intValue());
        } else {
            response.put("existingAmount", 0);
        }
        return response;
    }

    @PostMapping("/order_save")
    public String orderSave(@RequestParam("prod_ids") String prod_idsString, OrderVO vo,
                            HttpSession session, String paymentMethod, String account_transfer, String sender,
                            String deposit_name, String account_info, RedirectAttributes rttr) {

        List<Integer> prod_ids = new ArrayList<>();
        String[] prod_idsArray = prod_idsString.split(",");
        for (String id : prod_idsArray) {
            prod_ids.add(Integer.parseInt(id.trim()));
        }

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        vo.setU_id(u_id);

        orderService.orderProcess(vo, prod_ids, u_id, paymentMethod, deposit_name, account_info, session);

        String p_method_info = paymentMethod + "/" + account_transfer + "/" + sender;

        rttr.addAttribute("ord_code", vo.getOrd_code());

        return "redirect:/order/order_result";
    }

    @GetMapping("/order_result")
    public void orderResult(@RequestParam("ord_code") Integer ord_code, HttpSession session, Model model) {

        // 클라이언트에 표시할 정보
        String u_name = ((MemberVO)session.getAttribute("login_auth")).getU_name();
        model.addAttribute("u_name", u_name);

        Integer orderCode = orderService.getOrderByOrderCode(ord_code);
        model.addAttribute("ord_code", orderCode);

        String ord_email = ((MemberVO)session.getAttribute("login_auth")).getU_email();

    }
}

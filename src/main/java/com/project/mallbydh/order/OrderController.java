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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
                            @RequestParam(required = false) List<Integer> prod_ids, String type, HttpSession session, Model model) {

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();

        List<Map<String, Object>> orderCartDetails;

        if(type.equals("direct")) {
            // 상품페이지에서 주문 버튼 클릭 시
            CartVO newItem = new CartVO();
            newItem.setU_id(u_id);
            newItem.setProd_id(prod_id);
            newItem.setCart_amount(cart_amount);
            cartService.cart_add(newItem);
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

        // 로그인한 사용자 정보
        MemberVO memberVO = memberService.modifyView(u_id);
        model.addAttribute("memberVO", memberVO);

        return "order/order_form";
    }
}

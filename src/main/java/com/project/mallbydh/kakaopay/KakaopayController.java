package com.project.mallbydh.kakaopay;

import com.project.mallbydh.member.MemberVO;
import com.project.mallbydh.order.OrderService;
import com.project.mallbydh.order.OrderVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RequestMapping("/kakao/*")
@RequiredArgsConstructor
@Controller
public class KakaopayController {

    private final KakaopayService kakaopayService;
    private final OrderService orderService;

    private OrderVO order_info;
    private String u_id;
    private int order_total_price;
    private List<Integer> prod_ids; // 추가

    @PostMapping("/kakaoPay")
    public ResponseEntity<ReadyResponse> kakaoPay(
            @RequestParam("prod_idsString") String prod_idsString,
            @RequestParam("item_name") String item_name,
            @RequestParam("quantity") int quantity,
            @RequestParam("total_amount") int total_amount,
            OrderVO vo,
            HttpSession session) {

        // prod_ids 변환 및 저장
        List<Integer> prod_ids = new ArrayList<>();
        String[] prod_idsArray = prod_idsString.split(",");
        for (String id : prod_idsArray) {
            prod_ids.add(Integer.parseInt(id.trim()));
        }
        this.prod_ids = prod_ids; // 클래스 필드에 저장

        String u_id = ((MemberVO) session.getAttribute("login_auth")).getU_id();
        vo.setU_id(u_id);

        this.order_info = vo;
        this.order_total_price = total_amount;

        ResponseEntity<ReadyResponse> entity = null;

        // 가맹점 주문번호 생성
        String partner_order_id = "mallbydh[" + u_id + "] - " + new Date().toString();

        // 카카오페이 결제 준비 요청
        ReadyResponse readyResponse = kakaopayService.ready(
                partner_order_id,
                u_id,
                item_name,
                quantity,
                total_amount,
                0,  // tax_free_amount
                session
        );

        entity = new ResponseEntity<ReadyResponse>(readyResponse, HttpStatus.OK);

        return entity;
    }

    @GetMapping("/approval")
    public String approval(@RequestParam("pg_token") String pg_token, RedirectAttributes rttr, HttpSession session) {

        if (pg_token == null || pg_token.isEmpty()) {
            throw new IllegalArgumentException("pg_token이 전달되지 않았습니다.");
        } else {
            log.info("pg_token:" + pg_token);
        }

        String tid = (String) session.getAttribute("tid");
        String partner_order_id = (String) session.getAttribute("partner_order_id");
        String partner_user_id = (String) session.getAttribute("partner_user_id");

        String response = kakaopayService.approve(pg_token, tid, partner_order_id, partner_user_id);

        if(response.contains("aid")) {
            String u_id = ((MemberVO) session.getAttribute("login_auth")).getU_id();

            orderService.orderProcess(this.order_info, this.prod_ids, u_id, "카카오페이", null, null, session);
        }

        rttr.addAttribute("ord_code", order_info.getOrd_code());
        return "redirect:/order/order_result";
    }

    @GetMapping("/cancel")
    public String cancel(RedirectAttributes rttr) {
        rttr.addFlashAttribute("message", "결제가 취소되었습니다.");
        return "redirect:/order/order_form";
    }

    @GetMapping("/fail")
    public String fail(RedirectAttributes rttr) {
        rttr.addFlashAttribute("message", "결제에 실패하였습니다.");
        return "redirect:/order/order_form";
    }

    @PostMapping("/refund")
    public ResponseEntity refund(@RequestParam("tid") String tid,
                                 @RequestParam("cancel_amount") Integer cancel_amount,
                                 @RequestParam("cancel_tax_free_amount") Integer cancel_tax_free_amount) {

        KakaoCancelResponse kakaoCancelResponse = kakaopayService.kakaoCancel(tid, cancel_amount, cancel_tax_free_amount);

        return new ResponseEntity<>(kakaoCancelResponse, HttpStatus.OK);
    }

}

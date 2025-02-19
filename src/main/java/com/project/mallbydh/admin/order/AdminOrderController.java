package com.project.mallbydh.admin.order;

import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.AdminOrderSearchCriteria;
import com.project.mallbydh.common.utils.PageMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/order/*")
@Controller
public class AdminOrderController {

    private final AdminOrderService adminorderService;

    @GetMapping("/")
    public String adminOrderList(@ModelAttribute("cri")AdminOrderSearchCriteria cri, Model model) {

        cri.setPerPageNum(Constants.ADMIN_PRODUCT_LIST_COUNT);

        // 주문 상태 처리
        if (cri.getOrd_status() == null || cri.getOrd_status().isEmpty() || cri.getOrd_status().contains("all")) {
            cri.setOrd_status(Arrays.asList("입금대기", "결제완료", "배송준비", "배송중", "배송완료", "주문취소"));
        }

        // 결제 방법 처리
        if (cri.getPayment_method() == null || cri.getPayment_method().isEmpty() || cri.getPayment_method().contains("all")) {
            cri.setPayment_method(Arrays.asList("카드결제", "카카오페이", "무통장입금"));
        }

        List<Map<String, Object>> orderList = adminorderService.getOrderList(cri);
        model.addAttribute("orderList", orderList);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(adminorderService.getTotalOrderCount(cri));
        model.addAttribute("pageMaker", pageMaker);

        return "admin/order/list";
    }

    @GetMapping("/detail")
    public String adminOrderDetail() throws Exception {
        return "admin/order/detail";
    }

}

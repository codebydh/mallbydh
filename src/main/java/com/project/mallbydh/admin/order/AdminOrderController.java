package com.project.mallbydh.admin.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/order/*")
@Controller
public class AdminOrderController {

    private final AdminOrderService adminorderService;

    @GetMapping("/")
    public String adminOrderList() {
        return "admin/order/list";
    }

}

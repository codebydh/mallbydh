package com.project.mallbydh.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Controller
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order_form")
    public String orderForm(Model model) {
        return "order/order_form";
    }
}

package com.project.mallbydh.admin.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/product/*")
public class AdProductController {

    @GetMapping("/pro_insert")
    public String pro_insert(Model model) {
        model.addAttribute("currentPage", "pro_insert");
        return "/admin/product/pro_insert";
    }
}

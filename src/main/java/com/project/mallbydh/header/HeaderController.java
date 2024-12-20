package com.project.mallbydh.header;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HeaderController {
    private final HeaderService headerService;

    @GetMapping("/fragments/header")
    public String getHeader(Model model) {

        model.addAttribute("cate_list", headerService.getCategoryList());

        return "fragments/header";
    }
}

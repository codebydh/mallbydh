package com.project.mallbydh.wish;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/wish/*")
@RequiredArgsConstructor
@Controller
public class WishController {

    private final WishService wishService;
}

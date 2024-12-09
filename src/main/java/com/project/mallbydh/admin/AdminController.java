package com.project.mallbydh.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/admin/*")
@Controller
public class AdminController {
	
	// 관리자 로그인 페이지(=메인)
	@GetMapping("/")
	public String adminLogin() {
		return "admin/adLogin";
	}
	
	@GetMapping("/menu")
	public String adminMenu() {
		return "admin/adMenu";
	}
}

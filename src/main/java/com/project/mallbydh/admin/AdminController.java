package com.project.mallbydh.admin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
@Controller
public class AdminController {

	private final AdminService adminService;
	private final PasswordEncoder passwordEncoder;
	
	// 관리자 로그인 페이지(=메인)
	@GetMapping("/")
	public String adminLogin() {
		return "admin/adLogin";
	}

	@PostMapping("/adLoginPass")
	public String adLoginPass(AdminDTO dto, HttpSession session, RedirectAttributes rttr, String admin_id) throws Exception {

		AdminDTO db_vo = adminService.adLoginPass(dto.getAdmin_id());

		String url = "";
		String status = "";
		if(db_vo != null) {
			log.info("상태 : {}", db_vo.getAdmin_status());
			if("정지".equals(db_vo.getAdmin_status())) {
				status = "suspended";
				url = "/admin/";
			} else if(passwordEncoder.matches(dto.getAdmin_pw(), db_vo.getAdmin_pw())) {
				session.setAttribute("admin_auth", db_vo);
				adminService.updateAdminLastLogin(admin_id);
				url = "/admin/menu";
			} else {
				status = "pwFail";
				url = "/admin/";
			}
		} else {
			status = "idFail";
			url = "/admin/";
		}

		rttr.addFlashAttribute("status", status); // 타임리프파일에서 자바스크립트로 참조

		return "redirect:" + url;
	}
	
	@GetMapping("/menu")
	public String adminMenu(Model model) {
		model.addAttribute("currentPage", "menu");
		return "admin/adMenu";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/";
	}
}

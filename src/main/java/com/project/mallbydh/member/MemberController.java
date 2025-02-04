package com.project.mallbydh.member;

import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.mail.EmailDTO;
import com.project.mallbydh.order.OrderService;
import com.project.mallbydh.order.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.mallbydh.mail.EmailService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/member/*")
@Controller
@Slf4j
public class MemberController {

	private final FileUtils fileUtils;
	@Value("${com.project.mallbydh.upload.path}")
	private String uploadPath;
	
	private final EmailService emailService; // 이메일 기능
	private final PasswordEncoder passwordEncoder; // 비밀번호 암호화 기능
	private final MemberService memberService;
	private final OrderService orderService;
	
	// 회원가입 페이지
	@GetMapping("/join")
	public void join() {
			
	}
	
	// 회원정보 저장
	@PostMapping("/join")
	public String join(MemberVO vo) {

		// passwordEncoder.encode(vo.getU_pw()) : 비밀번호를 암호화
		vo.setU_pw(passwordEncoder.encode(vo.getU_pw()));

		// DB에 저장
		memberService.join(vo);

		return "redirect:/member/login";
	}
	
	// 아이디 중복체크
	@GetMapping("/idCheck")
	public ResponseEntity<String> idCheck(String u_id) throws Exception {
		
		ResponseEntity<String> entity = null;
		String isUse = "";
		
		if(memberService.idCheck(u_id) != null) {
			isUse = "no"; // 아이디 사용 불가능
		}else {
			isUse = "yes"; // 아이디 사용 가능
		}
		
		entity = new ResponseEntity<String>(isUse, HttpStatus.OK);
		
		return entity;
	}
	
	// 로그인 페이지
	@GetMapping("/login")
	public void login() {

	}
	
	// 로그인 처리
	@PostMapping("/login")
	public String loginProcess(LoginDTO dto, HttpSession session, RedirectAttributes rttr, String u_id) throws Exception {
		
		MemberVO memberVO = memberService.login(dto.getU_id());
		
		String url = "";
		String status = "";
		if(memberVO != null) { // 아이디가 존재  matches("사용자가 입력비밀번호", "db에서 가져온 암호된비밀번호")
			// 사용자가 입력한 비밀번호가 db에서 가져온 암호화된 비밀번호를 만드는 데 사용한 것인지 체크
			if(passwordEncoder.matches(dto.getU_pw(), memberVO.getU_pw())) { // 비번이 맞을 경우
				
				// 사용자를 인증처리하기위한 정보
				session.setAttribute("login_auth", memberVO);
				memberService.updateLastLogin(u_id); // 최근 로그인 시간 업데이트
				url = "/";
			}else { // 비번이 틀린 경우
				status = "pwFail";
				url = "/member/login";
			}
		}else {  // 아이디가 없을 경우
			status = "idFail";
			url = "/member/login";
		}
		
		if(session.getAttribute("targetUrl") != null) { // 이전주소가 존재하면
			url = (String) session.getAttribute("targetUrl");
		}
		
		// 이동되는 주소의 타임리프페이지에서 status 이름으로 사용할수가 있다. 페이지에서 자바스크립트 문법으로 사용
		rttr.addFlashAttribute("status", status);
		
		
		return "redirect:"+ url;
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 서버측의 세션으로 저장된 모든메모리가 소멸.
		
		return "redirect:/";
	}
	
	// ID/PW 찾기
	@GetMapping("/lostpass")
	public void lostpass() {

	}
	
	// 마이페이지 메인(주문내역)
	@GetMapping("/order")
	public void order(HttpSession session, Model model, SearchCriteria cri) throws Exception {
		String u_id = ((MemberVO) session.getAttribute("login_auth")).getU_id();
		cri.setPerPageNum(Constants.ADMIN_PRODUCT_LIST_COUNT);

		List<OrderVO> orderList = orderService.getOrdersByUserId(u_id, cri);

		// 경로의 역슬래시를 슬래시로 변환
		orderList.forEach(vo -> {
			vo.setProd_uploadfolder(vo.getProd_uploadfolder().replace("\\", "/"));
		});

		model.addAttribute("orderList", orderList);

		// 페이징 정보
		PageMaker pageMaker = new PageMaker();
		pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(orderService.getOrderCountByUserId(u_id, cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);
	}

	// 주문내역 날짜 범위 검색
	@PostMapping("/order")
	public ResponseEntity<?> processOrder(@RequestBody SearchCriteria cri, HttpSession session) {
		String u_id = ((MemberVO) session.getAttribute("login_auth")).getU_id();
		cri.setPerPageNum(Constants.ADMIN_PRODUCT_LIST_COUNT);

		List<OrderVO> orderList = orderService.getOrdersByUserId(u_id, cri);

		orderList.forEach(vo -> {
			vo.setProd_uploadfolder(vo.getProd_uploadfolder().replace("\\", "/"));
		});

		PageMaker pageMaker = new PageMaker();
		pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(orderService.getOrderCountByUserId(u_id, cri));

		Map<String, Object> response = new HashMap<>();
		response.put("orderList", orderList);
		response.put("pageMaker", pageMaker);

		return ResponseEntity.ok(response);
	}


	@GetMapping("/order/detail")
	public String orderDetail(Integer ord_code, Model model) {
		List<Map<String, Object>> orderInfo = orderService.getOrderDetailInfo(ord_code);

		// 역슬래시 - 슬래시로 변환
		orderInfo.forEach(map -> {
			String uploadFolder = (String) map.get("prod_uploadfolder");
			map.put("prod_uploadfolder", uploadFolder.replace("\\", "/"));
		});

		model.addAttribute("orderInfo", orderInfo);

		return "member/order/detail";
	}


	// 회원수정(불러오기)
	@GetMapping("/modify")
	public void modify(HttpSession session, Model model) throws Exception {
		
		String u_id = ((MemberVO) session.getAttribute("login_auth")).getU_id();
		
		MemberVO memberVO = memberService.modifyView(u_id);
		
		model.addAttribute("memberVO", memberVO);
	}

	// 회원수정(DB UPDATE)
	@PostMapping("/modify")
	public String modify(MemberVO vo) throws Exception {
		
		memberService.modifySave(vo);
		
		return "redirect:/";
	}
	
	// 비밀번호 변경하기 폼
	@GetMapping("/pwchange")
	public void pwchange() throws Exception {
		
	}

	@PostMapping("/pwchange")
	public ResponseEntity<String> pwchange(@RequestParam("cur_pw") String u_pw, String new_pw, HttpSession session) throws Exception {

		ResponseEntity<String> entity = null;
		String msg = "";

		String db_pw = ((MemberVO) session.getAttribute("login_auth")).getU_pw();
		String u_id = ((MemberVO) session.getAttribute("login_auth")).getU_id();
		String u_email = ((MemberVO) session.getAttribute("login_auth")).getU_email();

		if(passwordEncoder.matches(u_pw, db_pw)) {
			String encode_new_pw = passwordEncoder.encode(new_pw); // 새 비밀번호를 암호화
			memberService.pwchange(u_id, encode_new_pw); // 아이디와 암호화된 비밀번호를 DB로 전달
			msg = "success";

			// 비밀번호 변경 알림 메일 발송
			String type = "mail/pwchange";

			EmailDTO dto = new EmailDTO();
			dto.setReceiverMail(u_email);
			dto.setSubject("mallbydh 회원 비밀번호 변경 안내");

			emailService.sendMail(type, dto, new_pw);
		}else {
			msg = "fail";
		}

		entity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/idsearch")
	public ResponseEntity<String> idsearch(String u_name, String u_email) throws Exception {

		ResponseEntity<String> entity = null;

		String result = "";

		String u_id = memberService.idsearch(u_name, u_email);

		if(u_id != null) {

			// 아이디 메일발송
			String type = "mail/idsearch";

			EmailDTO dto = new EmailDTO();
			dto.setReceiverMail(u_email); // 받는사람 메일주소
			dto.setSubject("codebydh 아이디 찾기결과를 보냅니다.");

			result = "success";
			emailService.sendMail(type, dto, u_id);
		}else {
			result = "fail";
		}

		entity = new ResponseEntity<String>(result, HttpStatus.OK);

		return entity;
	}

	@GetMapping("/pwtemp")
	public ResponseEntity<String> pwtemp(String u_id, String u_name, String u_email) throws Exception {

		ResponseEntity<String> entity = null;
		String result = "";

		String d_u_email = memberService.pwtempComfirm(u_id, u_name, u_email);

		if(d_u_email != null) {
			result = "success";
			String tempPw = emailService.createAuthCode(); // 이메일 인증 함수를 동일하게 사용함.

			memberService.pwchange(u_id, passwordEncoder.encode(tempPw)); // tempPw 암호화

			// 임시 비밀번호 메일 발송
			String type = "mail/pwtemp";

			EmailDTO dto = new EmailDTO();
			dto.setReceiverMail(d_u_email);
			dto.setSubject("mallbydh 임시 비밀번호 안내");

			emailService.sendMail(type, dto, tempPw);
		}else {
			result = "fail";
		}

		entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;

	}



	// 찜한상품
	@GetMapping("/wishlist")
	public void wishlist() throws Exception {
		
	}
	
	// 나의 상품리뷰
	@GetMapping("/myreview")
	public void myreview() throws Exception {
		
	}
	
	// 나의 상품문의
	@GetMapping("/myinquiry")
	public void myinquiry() throws Exception {
		
	}
	
	// 로그인기록
	@GetMapping("/log")
	public void log() throws Exception {
		
	}
	
	// 계정삭제
	@GetMapping("/delete")
	public void delete() throws Exception {
		
	}

	@GetMapping("/image_display")
	public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {

		return fileUtils.getFile(uploadPath + "\\" + dateFolderName, fileName);
	}
	


}

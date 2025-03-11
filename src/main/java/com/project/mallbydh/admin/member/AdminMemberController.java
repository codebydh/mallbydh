package com.project.mallbydh.admin.member;

import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.member.MemberService;
import com.project.mallbydh.member.MemberVO;
import com.project.mallbydh.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/member/*")
@Controller
public class AdminMemberController {

    private final AdminMemberService adminMemberService;
    private final MemberService memberService;
    private final OrderService orderService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String adminMember(@ModelAttribute("cri") SearchCriteria cri, @ModelAttribute("u_status") String u_status,
                              @ModelAttribute("u_gender") String u_gender, @ModelAttribute("u_emailreceive") String u_emailreceive,
                              @ModelAttribute("u_smsreceive") String u_smsreceive, Model model) {

        List<Map<String, Object>> memberList = adminMemberService.getMembers(cri, u_status, u_gender, u_emailreceive, u_smsreceive);
        model.addAttribute("memberList", memberList);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(adminMemberService.getTotalCount(cri, u_status, u_gender, u_emailreceive, u_smsreceive));
        model.addAttribute("pageMaker", pageMaker);

        return "admin/member/member";
    }

    @GetMapping("/edit")
    public String memberEdit(String u_id, Model model) throws Exception {

        MemberVO memberVO = memberService.modifyView(u_id);
        model.addAttribute("memberVO", memberVO);

        Integer totalAmount = orderService.userTotalAmount(u_id);
        model.addAttribute("totalAmount", totalAmount);

        return "admin/member/edit";
    }

    @PostMapping("/update")
    public String memberUpdate(MemberVO vo) throws Exception {

        // 비밀번호가 입력된 경우에만 암호화 처리
        if (vo.getU_pw() != null && !vo.getU_pw().isEmpty()) {
            String encodedPassword = passwordEncoder.encode(vo.getU_pw()); // 비밀번호 암호화
            vo.setU_pw(encodedPassword);
        } else {
            vo.setU_pw(null);
        }

        adminMemberService.adminUserUpdate(vo);

        return "redirect:/admin/member/";
    }

    @PostMapping("/suspend")
    public ResponseEntity<String> memberSuspend(@RequestParam("u_id") String u_id) throws Exception {
        ResponseEntity<String> entity = null;

        adminMemberService.memberSuspend(u_id);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);

        return entity;
    }
}

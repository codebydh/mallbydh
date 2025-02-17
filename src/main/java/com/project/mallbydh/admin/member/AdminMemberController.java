package com.project.mallbydh.admin.member;

import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.member.MemberService;
import com.project.mallbydh.member.MemberVO;
import com.project.mallbydh.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "/admin/member/member";
    }

    @GetMapping("/edit")
    public String memberEdit(String u_id, Model model) throws Exception {

        MemberVO memberVO = memberService.modifyView(u_id);
        model.addAttribute("memberVO", memberVO);

        Integer totalAmount = orderService.userTotalAmount(u_id);
        model.addAttribute("totalAmount", totalAmount);

        return "/admin/member/edit";
    }

    @PostMapping("/update")
    public String memberUpdate(MemberVO vo) throws Exception {

        memberService.modifySave(vo);

        return "redirect:/admin/member/";
    }
}

package com.project.mallbydh.admin.manager;

import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/manager/*")
@Controller
public class ManagerController {

    private final ManagerService managerService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String managerList(@ModelAttribute("cri") SearchCriteria cri, @ModelAttribute("admin_status") String admin_status, Model model) throws Exception {

        List<AdminVO> managerList = managerService.getManagers(cri, admin_status);
        model.addAttribute("managerList", managerList);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(managerService.getManagerTotalCount(cri, admin_status));
        model.addAttribute("pageMaker", pageMaker);

        return "/admin/manager/list";
    }

    @PostMapping("/new")
    public ResponseEntity<String> registerManager(AdminVO vo) {
        ResponseEntity<String> entity = null;

        // 비밀번호 암호화 후 등록(insert)
        vo.setAdmin_pw(passwordEncoder.encode(vo.getAdmin_pw()));
        managerService.insertManager(vo);

        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

}

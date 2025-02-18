package com.project.mallbydh.admin.manager;

import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/manager/*")
@Controller
public class ManagerController {

    private final ManagerService managerService;

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
}

package com.project.mallbydh.admin.inquiry;

import com.project.mallbydh.admin.AdminDTO;
import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.inquiry.AnswerVO;
import com.project.mallbydh.inquiry.InquiryAnswerVO;
import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/inquiry/*")
@Controller
public class AdminInquiryController {

    private final AdminInquiryService adminInquiryService;
    private final FileUtils fileUtils;

    @Value("${com.project.mallbydh.upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String inquiryList(@ModelAttribute("cri") SearchCriteria cri, @RequestParam(value = "ans_status", required = false) String ans_status, Model model) {
        cri.setPerPageNum(Constants.ADMIN_PRODUCT_LIST_COUNT);

        List<InquiryAnswerVO> inquiryList = adminInquiryService.getInquiryList(cri, ans_status);

//        inquiryList.forEach(vo -> {
//            String uploadFolder = vo.getProduct().getProd_uploadfolder();
//            if (uploadFolder != null) {
//                vo.getProduct().setProd_uploadfolder(uploadFolder.replace("\\", "/"));
//            }
//        });

        model.addAttribute("inquiryList", inquiryList);

        // 페이징 정보
        PageMaker pageMaker = new PageMaker();
        pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(adminInquiryService.getInquiryCount(cri, ans_status));
        model.addAttribute("pageMaker", pageMaker);

        return "admin/inquiry/list";
    }

    @PostMapping("/delete")
    public ResponseEntity<String> adminInquiryDelete(@RequestParam("inq_code") Integer inq_code, Integer prod_id) throws Exception {
        ResponseEntity<String> entity = null;
        adminInquiryService.inquiryDelete(inq_code, prod_id);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("inq_code") Integer inq_code, Model model) {
        Map<String, Object> inquiryContent = adminInquiryService.getInquiryContent(inq_code);
//        // 경로의 역슬래시를 슬래시로 전환
//        String uploadFolder = ((String) inquiryContent.get("prod_uploadfolder")).replace("\\", "/");
//        inquiryContent.put("prod_uploadfolder", uploadFolder);
        model.addAttribute("inquiryContent", inquiryContent);
        return "admin/inquiry/edit";
    }

    @PostMapping("/update")
    public ResponseEntity<String> adminInquiryUpdate(InquiryAnswerVO vo) throws Exception {
        ResponseEntity<String> entity = null;
        adminInquiryService.inquiryUpdate(vo);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/answer")
    public String answerPage(@RequestParam("inq_code") Integer inq_code, HttpSession session, Model model) {
        Map<String, Object> inquiryContent = adminInquiryService.getInquiryContent(inq_code);
//        // 경로의 역슬래시를 슬래시로 전환
//        String uploadFolder = ((String) inquiryContent.get("prod_uploadfolder")).replace("\\", "/");
//        inquiryContent.put("prod_uploadfolder", uploadFolder);
        model.addAttribute("inquiryContent", inquiryContent);

        String admin_id = ((AdminDTO)session.getAttribute("admin_auth")).getAdmin_id();
        model.addAttribute("admin_id", admin_id);

        return "admin/inquiry/answer";
    }

    @PostMapping("/answer_register")
    public ResponseEntity<String> registerNewAnswer(AnswerVO vo, @RequestParam("inq_code") Integer inq_code) throws Exception {
        ResponseEntity<String> entity = null;
        adminInquiryService.inquiryInsert(inq_code, vo);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/edit_answer")
    public String editAnswer(@RequestParam("ans_code") Integer ans_code, HttpSession session, Model model) {
        Map<String, Object> answerContent = adminInquiryService.getAnswerContent(ans_code);
        model.addAttribute("answerContent", answerContent);

        String admin_id = ((AdminDTO)session.getAttribute("admin_auth")).getAdmin_id();
        model.addAttribute("admin_id", admin_id);

        return "admin/inquiry/edit_answer";
    }

    @PostMapping("/answer_modify")
    public ResponseEntity<String> modifyAnswer(AnswerVO vo) throws Exception {
        ResponseEntity<String> entity = null;
        adminInquiryService.updateAnswer(vo);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/delete_answer")
    public ResponseEntity<String> answerDelete(@RequestParam("ans_code") Integer ans_code) throws Exception {
        ResponseEntity<String> entity = null;
        adminInquiryService.answerDelete(ans_code);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/image_display")
    public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {
        return fileUtils.getFile(uploadPath + File.separator + dateFolderName, fileName);
    }
}

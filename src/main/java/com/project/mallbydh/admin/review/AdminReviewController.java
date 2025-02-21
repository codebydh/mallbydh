package com.project.mallbydh.admin.review;

import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/review/*")
@Controller
public class AdminReviewController {

    private final AdminReviewService adminReviewService;
    private final FileUtils fileUtils;

    @Value("${com.project.mallbydh.upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String reviewList(@ModelAttribute("cri") SearchCriteria cri, @RequestParam(value = "rev_rate", required = false) Integer rev_rate, Model model) {
        cri.setPerPageNum(Constants.ADMIN_PRODUCT_LIST_COUNT);

        List<Map<String, Object>> reviewList = adminReviewService.getReviewList(cri, rev_rate);
        model.addAttribute("reviewList", reviewList);

        // 페이징 정보
        PageMaker pageMaker = new PageMaker();
        pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(adminReviewService.getReviewCount(cri, rev_rate));
        model.addAttribute("pageMaker", pageMaker);

        return "admin/review/list";
    }

    @GetMapping("/image_display")
    public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {
        return fileUtils.getFile(uploadPath + "\\" + dateFolderName, fileName);
    }
}

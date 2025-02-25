package com.project.mallbydh.admin.review;

import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.review.ReviewVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        reviewList.forEach(vo -> {
            String uploadFolder = (String) vo.get("prod_uploadfolder");
            if (uploadFolder != null) {
                vo.put("prod_uploadfolder", uploadFolder.replace("\\", "/"));
            }
        });

        model.addAttribute("reviewList", reviewList);

        // 페이징 정보
        PageMaker pageMaker = new PageMaker();
        pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(adminReviewService.getReviewCount(cri, rev_rate));
        model.addAttribute("pageMaker", pageMaker);

        return "admin/review/list";
    }

    @PostMapping("/delete")
    public ResponseEntity<String> adminReviewDelete(@RequestParam("rev_code") Integer rev_code) throws Exception {
        ResponseEntity<String> entity = null;
        adminReviewService.reviewDelete(rev_code);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("rev_code") Integer rev_code, Model model) {
        Map<String, Object> reviewContent = adminReviewService.getReviewContent(rev_code);
        model.addAttribute("reviewContent", reviewContent);
        return "admin/review/edit";
    }

    @PostMapping("/update")
    public ResponseEntity<String> adminReviewUpdate(ReviewVO vo) throws Exception {
        ResponseEntity<String> entity = null;
        adminReviewService.reviewUpdate(vo);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/image_display")
    public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {
        return fileUtils.getFile(uploadPath + "\\" + dateFolderName, fileName);
    }
}

package com.project.mallbydh.review;

import com.project.mallbydh.admin.review.AdminReviewService;
import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {

    private final ReviewService reviewService;
    private final AdminReviewService adminReviewService;

    // 상품 후기 목록 작업
    @GetMapping("/rev_list/{prod_id}/{page}")
    public ResponseEntity<Map<String, Object>> rev_list(@PathVariable("prod_id") Integer prod_id, @PathVariable("page") int page) throws Exception {
        ResponseEntity<Map<String, Object>> entity = null;
        Map<String, Object> map = new HashMap<>();

        // 상품 후기 목록
        SearchCriteria cri = new SearchCriteria();
        cri.setPage(page);
        cri.setPerPageNum(5);
        List<ReviewVO> rev_list = reviewService.rev_list(prod_id, cri);

        // 상품후기 페이징 정보
        PageMaker revPageMaker = new PageMaker();
        revPageMaker.setCri(cri);
        revPageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        revPageMaker.setTotalCount(reviewService.getReviewCountByProdId(prod_id));

        map.put("rev_list", rev_list);
        map.put("revPageMaker", revPageMaker);

        entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        return entity;
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> rev_save(@RequestBody ReviewVO vo, HttpSession session) throws Exception {
        ResponseEntity<String> entity = null;

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        vo.setU_id(u_id);
        reviewService.reviewSave(vo);

        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/delete")
    public ResponseEntity<String> userReviewDelete(Integer rev_code, Integer prod_id) throws Exception {
        ResponseEntity<String> entity = null;
        adminReviewService.reviewDelete(rev_code, prod_id);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/update")
    public ResponseEntity<String> reviewUpdate(ReviewVO vo) throws Exception {
        ResponseEntity<String> entity = null;
        adminReviewService.reviewUpdate(vo);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }
}

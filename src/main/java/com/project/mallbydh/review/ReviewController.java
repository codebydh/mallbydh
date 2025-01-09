package com.project.mallbydh.review;

import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {

    private final ReviewService reviewService;

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
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        pageMaker.setTotalCount(reviewService.getReviewCountByProdId(prod_id));

        map.put("rev_list", rev_list);
        map.put("pageMaker", pageMaker);

        entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        return entity;
    }
}

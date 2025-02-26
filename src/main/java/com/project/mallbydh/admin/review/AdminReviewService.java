package com.project.mallbydh.admin.review;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.product.ProductMapper;
import com.project.mallbydh.review.ReviewVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class AdminReviewService {

    private final AdminReviewMapper adminReviewMapper;
    private final ProductMapper productMapper;

    public List<Map<String, Object>> getReviewList(SearchCriteria cri, Integer rev_rate) {
        return adminReviewMapper.getReviewList(cri, rev_rate);
    }

    public int getReviewCount(SearchCriteria cri, Integer rev_rate) {
        return adminReviewMapper.getReviewCount(cri, rev_rate);
    }

    public void reviewDelete(Integer rev_code, Integer prod_id) {
        // 리뷰를 삭제하고
        adminReviewMapper.reviewDelete(rev_code);
        // 해당 상품의 DB에서 카운트를 -1함
        productMapper.subtractReviewCount(prod_id);
    }

    public Map<String, Object> getReviewContent(Integer rev_code) {
        return adminReviewMapper.getReviewContent(rev_code);
    }

    public void reviewUpdate(ReviewVO vo) {
        adminReviewMapper.reviewUpdate(vo);
    }
}

package com.project.mallbydh.review;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewMapper reviewMapper;
    private final ProductMapper productMapper;

    public List<ReviewVO> rev_list(Integer prod_id, SearchCriteria cri) {
        return reviewMapper.rev_list(prod_id, cri);
    }

    public int getReviewCountByProdId(Integer prod_id) {
        return reviewMapper.getReviewCountByProdId(prod_id);
    }

    public void reviewSave(ReviewVO vo) {
        // 1. 상품 후기 등록
        reviewMapper.reviewSave(vo);
        // 2. 상품 후기 +1 가산 (상품테이블)
        productMapper.updateReviewCount(vo.getProd_id());
    }
}

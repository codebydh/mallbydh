package com.project.mallbydh.review;

import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public List<ReviewVO> rev_list(Integer prod_id, SearchCriteria cri) {
        return reviewMapper.rev_list(prod_id, cri);
    }

    public int getReviewCountByProdId(Integer prod_id) {
        return reviewMapper.getReviewCountByProdId(prod_id);
    }
}

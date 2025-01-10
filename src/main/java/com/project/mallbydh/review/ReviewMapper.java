package com.project.mallbydh.review;

import com.project.mallbydh.common.utils.SearchCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewMapper {

    List<ReviewVO> rev_list(@Param("prod_id") Integer prod_id, @Param("cri")SearchCriteria cri);

    int getReviewCountByProdId(Integer prod_id);

    void reviewSave(ReviewVO vo);
}

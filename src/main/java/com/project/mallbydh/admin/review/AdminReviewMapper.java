package com.project.mallbydh.admin.review;

import com.project.mallbydh.common.utils.SearchCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminReviewMapper {

    List<Map<String, Object>> getReviewList(@Param("cri") SearchCriteria cri, @Param("rev_rate") Integer rev_rate);

    int getReviewCount(@Param("cri") SearchCriteria cri, @Param("rev_rate") Integer rev_rate);

    void reviewDelete(Integer rev_code);
}

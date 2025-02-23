package com.project.mallbydh.admin.inquiry;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.inquiry.InquiryAnswerVO;
import com.project.mallbydh.review.ReviewVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminInquiryMapper {

    List<Map<String, Object>> getInquiryList(@Param("cri") SearchCriteria cri, @Param("ans_status") String ans_status);

    int getInquiryCount(@Param("cri") SearchCriteria cri, @Param("ans_status") String ans_status);

    void inquiryDelete(Integer inq_code);

    Map<String, Object> getInquiryContent(Integer inq_code);

    void inquiryUpdate(InquiryAnswerVO vo);
}

package com.project.mallbydh.admin.inquiry;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.inquiry.AnswerVO;
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

    void inquiryInsert(@Param("inq_code") Integer inq_code, @Param("vo") AnswerVO vo);

    Map<String, Object> getAnswerContent(Integer ans_code);

    void updateAnswer(AnswerVO vo);

    void answerDelete(Integer ans_code);
}

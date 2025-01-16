package com.project.mallbydh.inquiry;

import com.project.mallbydh.common.utils.SearchCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryMapper {

    List<InquiryAnswerVO> inq_list(@Param("prod_id") Integer prod_id, @Param("cri") SearchCriteria cri);

    int getInquiryCountByProdId(Integer prod_id);

    void inquirySave(InquiryAnswerVO vo);
}

package com.project.mallbydh.admin.inquiry;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.inquiry.AnswerVO;
import com.project.mallbydh.inquiry.InquiryAnswerVO;
import com.project.mallbydh.product.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class AdminInquiryService {

    private final AdminInquiryMapper adminInquiryService;
    private final ProductMapper productMapper;

    public List<InquiryAnswerVO> getInquiryList(SearchCriteria cri, String ans_status) {
        return adminInquiryService.getInquiryList(cri, ans_status);
    }

    public int getInquiryCount(SearchCriteria cri, String ans_status) {
        return adminInquiryService.getInquiryCount(cri, ans_status);
    }

    public void inquiryDelete(Integer rev_code, Integer prod_id) {
        adminInquiryService.inquiryDelete(rev_code);
        productMapper.subtractInquiryCount(prod_id);
    }

    public Map<String, Object> getInquiryContent(Integer rev_code) {
        return adminInquiryService.getInquiryContent(rev_code);
    }

    public void inquiryUpdate(InquiryAnswerVO vo) {
        adminInquiryService.inquiryUpdate(vo);
    }

    public void inquiryInsert(Integer inq_code, AnswerVO vo) {
        adminInquiryService.inquiryInsert(inq_code, vo);
    }

    public Map<String, Object> getAnswerContent(Integer ans_code) {
        return adminInquiryService.getAnswerContent(ans_code);
    }

    public void updateAnswer(AnswerVO vo) {
        adminInquiryService.updateAnswer(vo);
    }

    public void answerDelete(Integer ans_code) {
        adminInquiryService.answerDelete(ans_code);
    }
}

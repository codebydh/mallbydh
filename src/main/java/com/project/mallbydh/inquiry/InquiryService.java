package com.project.mallbydh.inquiry;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.product.ProductMapper;
import com.project.mallbydh.review.ReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InquiryService {

    private final InquiryMapper inquiryMapper;
    private final ProductMapper productMapper;

    List<InquiryAnswerVO> inq_list(Integer prod_id, SearchCriteria cri) {
        return inquiryMapper.inq_list(prod_id, cri);
    }

    public int getInquiryCountByProdId(Integer prod_id) {
        return inquiryMapper.getInquiryCountByProdId(prod_id);
    }

    public void inquirySave(InquiryAnswerVO vo) {
        // 1. 질문 등록
        inquiryMapper.inquirySave(vo);
        // 2. 질문 +1 가산 (상품테이블)
        productMapper.updateInquiryCount(vo.getProd_id());
    }

    public List<InquiryAnswerVO> getInquiryListByUserId(String u_id, SearchCriteria cri) {
        return inquiryMapper.getInquiryListByUserId(u_id, cri);
    }

    public int getInquiryCountByProdId(String u_id) {
        return inquiryMapper.getInquiryCountByUserId(u_id);
    }
}

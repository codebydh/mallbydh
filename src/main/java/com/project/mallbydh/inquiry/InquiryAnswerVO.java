package com.project.mallbydh.inquiry;

import com.project.mallbydh.admin.product.ProductVO;
import com.project.mallbydh.member.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class InquiryAnswerVO {

    // inquiry_tbl
    private Integer inq_code;
    private String u_id;
    private int prod_id;
    private String inq_title;
    private String inq_content;
    private Date inq_regdate;

    // answer_tbl
    private List<AnswerVO> answers;

    private MemberVO user;
    private ProductVO product;
}

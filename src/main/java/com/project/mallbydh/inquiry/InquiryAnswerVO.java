package com.project.mallbydh.inquiry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class InquiryAnswerVO {

    // inquiry_tbl
    private int inq_code;
    private String u_id;
    private int prod_id;
    private String inq_title;
    private String inq_content;
    private Date inq_regdate;

    // answer_tbl
    private int ans_code;
    private String admin_id;
    private String ans_content;
    private Date ans_regdate;

    private String prod_name;
}

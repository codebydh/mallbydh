package com.project.mallbydh.inquiry;

import com.project.mallbydh.admin.AdminDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AnswerVO {
    // answer_tbl
    private Integer ans_code;
    private String ans_content;
    private Date ans_regdate;
    private String admin_id;
    private AdminDTO admin;
}

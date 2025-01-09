package com.project.mallbydh.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewVO {

    private Long rev_code;
    private String u_id;
    private Integer prod_id;
    private String rev_title;
    private String rev_content;
    private int rev_rate;
    private LocalDateTime rev_regdate;
}

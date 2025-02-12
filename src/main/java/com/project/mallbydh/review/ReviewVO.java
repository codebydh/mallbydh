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
    private String prod_uploadfolder;
    private String prod_img;
    private String prod_name;
    private String rev_rate_stars; // 별점을 숫자에서 별 모양으로 변환하기 위한 필드
}

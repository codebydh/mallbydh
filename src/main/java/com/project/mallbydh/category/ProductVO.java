package com.project.mallbydh.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductVO {
    private Integer prod_id;
    private Integer cate_id; // 2차 카테고리
    private String prod_name;
    private int prod_price;
    private int prod_amount;
    private int prod_discount;
    private String prod_maker;
    private String prod_content;
    private String prod_uploadfolder;
    private String prod_img;
    private String prod_forsale;
    private Date prod_regdate;
    private Date prod_updatedate;
}

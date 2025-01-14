package com.project.mallbydh.wish;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WishVO {

    private Integer wish_code;
    private Integer prod_id;
    private String u_id;
    private int wish_amount;
}

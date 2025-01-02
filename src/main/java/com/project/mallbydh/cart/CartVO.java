package com.project.mallbydh.cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CartVO {

    private Integer prod_id;
    private String u_id;
    private int cart_amount;
    private Date cart_date;
}

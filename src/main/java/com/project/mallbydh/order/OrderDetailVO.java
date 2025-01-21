package com.project.mallbydh.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailVO {
    private Integer ord_code;
    private Integer prod_id;
    private int ordt_amount;
    private int ordt_price;
}

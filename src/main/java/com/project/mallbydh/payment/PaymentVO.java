package com.project.mallbydh.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PaymentVO {
    private Integer payment_id;
    private Integer ord_code;
    private String u_id;
    private String payment_method;
    private int payment_price;
    private String payment_status;
    private Date payment_date;
    private String account_info;
    private String deposit_name;
    private String tid;
}

package com.project.mallbydh.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderVO {
    private Integer ord_code;
    private String u_id;
    private String ord_name;
    private String ord_phone;
    private String ord_zipcode;
    private String ord_addr;
    private String ord_addr_detail;
    private int ord_price;
    private Date ord_date;
}

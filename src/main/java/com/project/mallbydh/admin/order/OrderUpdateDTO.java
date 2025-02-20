package com.project.mallbydh.admin.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderUpdateDTO {
    private Integer ord_code;
    private String ord_status;
    private String carrier;
    private String tracking_number;
    private String account_info;
    private String deposit_name;
    private String recipient_name;
    private String recipient_phone;
    private String delivery_zipcode;
    private String delivery_addr;
    private String delivery_addr_detail;
    private String delivery_message;
}

package com.project.mallbydh.delivery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class DeliveryVO {
    private Integer delivery_id;
    private Integer ord_code;
    private String delivery_zipcode;
    private String delivery_addr;
    private String delivery_addr_detail;
    private String delivery_message;
    private String recipient_name;
    private String recipient_phone;
    private String delivery_status;
    private String tracking_number;
    private String carrier;
    private Date invoice_date;
    private Date created_at;
    private Date updated_at;
}

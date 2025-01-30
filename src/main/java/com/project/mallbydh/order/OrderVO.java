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
    private String recipient_name; // (구)ord_name, 수령인명
    private String recipient_phone; // (구)ord_phone, 수령인연락처
    private String delivery_zipcode; // (구)ord_zipcode, 배송주소-우편번호
    private String delivery_addr; // (구)ord_addr, 배송주소-기본주소
    private String delivery_addr_detail; // (구)ord_addr_detail, 배송주소-상세주소
    private int ord_price;
    private Date ord_date;
    private String delivery_message; // (추가)배송메세지
    private String ord_name; // (추가)주문명 (ex. 상품aaa 외 2)
    private String ord_status; // (추가)주문상태(결제대기~배송완료)
}

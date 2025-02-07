package com.project.mallbydh.kakaopay;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReadyRequest {

    private String cid;
    private String partner_order_id;
    private String partner_user_id;
    private String item_name;
    private int  quantity;
    private int total_amount;
    private int tax_free_amount;
    private String approval_url;
    private String cancel_url;
    private String fail_url;

    public ReadyRequest(String cid, String partner_order_id) {
        this.cid = cid;
        this.partner_order_id = partner_order_id;
    }
}

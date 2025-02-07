package com.project.mallbydh.kakaopay;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ReadyResponse {

    private String tid;
    private String next_redirect_pc_url;
    private Date created_at;
}

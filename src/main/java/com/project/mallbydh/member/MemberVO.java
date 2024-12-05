package com.project.mallbydh.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberVO {
    private String u_id;
    private String u_pw;
    private String u_name;
    private String u_phone;
    private String u_smsreceive;
    private String u_email;
    private String u_emailreceive;
    private String u_birth;
    private String u_gender;
    private String u_zipcode;
    private String u_addr;
    private String u_addr_detail;
    private int u_point;
    private Date u_regdate;
    private Date u_updatedate;
    private Date u_lastlogin;
}

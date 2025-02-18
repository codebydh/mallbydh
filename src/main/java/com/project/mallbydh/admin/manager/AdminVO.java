package com.project.mallbydh.admin.manager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
public class AdminVO {
    private String admin_id;
    private String admin_pw;
    private String admin_name;
    private Date admin_regdate;
    private Date admin_lastlogin;
    private String admin_status;
}

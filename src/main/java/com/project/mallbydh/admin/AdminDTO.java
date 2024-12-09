package com.project.mallbydh.admin;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminDTO {
	private String admin_id;
	private String admin_pw;
	private String admin_name;
	private Date admin_regdate;
	private Date admin_lastlogin;
}

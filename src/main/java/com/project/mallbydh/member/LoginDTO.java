package com.project.mallbydh.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {
	
	private String u_id;
	private String u_pw;
	private String u_status;
}

package com.project.mallbydh.common.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class AdminOrderSearchCriteria extends Criteria {
	
	private String searchType; // 검색종류(제목, 내용, 작성자 선택)
	private String keyword;    // 검색어
	private String startDate; // 날짜검색시작일
	private String endDate;   // 날짜검색종료일
	private List<String> payment_method;
	private List<String> ord_status;
	private String recipient_name;
	private String recipient_phone;
	private String delivery_addr;
	private String u_id;
	private String u_addr;
	private String u_name;
	private String u_phone;
}

package com.project.mallbydh.common.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

// 페이징기능을 구현하기위한 클래스
//       1	 2	3	4	5 [next]
//[prev] 6	 7	8	9	10
public class PageMaker {

	private int totalCount;  // 테이블의 총 데이타 개수
	private int startPage;   // 각 블럭의 시작페이지 값
	private int endPage;     // 각 블럭의 마지막페이지 값
	private boolean prev;    // 이전 표시여부
	private boolean next;    // 다음 표시여부
	
	private int displayPageNum = 10;  // 블럭에 보여줄 페이지 번호개수 1	2	3	4	5	6	7	8	9	10
	
	private Criteria cri;  // page, perPageNum

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount; // 테이블의 총 데이타 개수가 13
		
		calcData();
	}
	
	// 페이징 기능에 필요한 계산
	private void calcData() {
		
		// 사용자가 displayPageNum = 10
		/*
		  1	 2	3	4	5	6	7	8	9	10
		  11 12	13	14	15	16	17	18	19	20
		  21 22	23	24	25	26	27	28	29	30			
		 */
		
		
		//  (int) (10.0);  = 10          
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum ) * displayPageNum);
		
		// (10 - 10) + 1;
		startPage = (endPage - displayPageNum) + 1;
		
		// 테이블 총 데이타개수를 참조하여, 출력할 실제 endPage 값.   totalCount=13, perPageNum=10
		// int tempEndPage = (int)(2.0);
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public void setDisplayPageNum( int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	// 페이징기능만 사용시 필요한 파라미터 작업
	public String makeQuery(int page) {
		
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}
	
	// 페이징, 검색기능 사용시 필요한 파라미터 생성해주는 기능.
	// ?page=2&perPageNum=10&searchType&keyword
	public String makeSearch(int page) {
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum());

		if (cri instanceof AdminOrderSearchCriteria) {
			AdminOrderSearchCriteria searchCriteria = (AdminOrderSearchCriteria) cri;

			addParamIfNotNull(builder, "searchType", searchCriteria.getSearchType());
			addParamIfNotNull(builder, "keyword", searchCriteria.getKeyword());
			addParamIfNotNull(builder, "startDate", searchCriteria.getStartDate());
			addParamIfNotNull(builder, "endDate", searchCriteria.getEndDate());

			addMultipleParams(builder, "ord_status", searchCriteria.getOrd_status());
			addMultipleParams(builder, "payment_method", searchCriteria.getPayment_method());

			addParamIfNotNull(builder, "recipient_name", searchCriteria.getRecipient_name());
			addParamIfNotNull(builder, "recipient_phone", searchCriteria.getRecipient_phone());
			addParamIfNotNull(builder, "delivery_addr", searchCriteria.getDelivery_addr());
			addParamIfNotNull(builder, "u_id", searchCriteria.getU_id());
			addParamIfNotNull(builder, "u_addr", searchCriteria.getU_addr());
			addParamIfNotNull(builder, "u_name", searchCriteria.getU_name());
			addParamIfNotNull(builder, "u_phone", searchCriteria.getU_phone());
		}

		return builder.build().toUriString(); // 인코딩을 제거했습니다.
	}

	private void addMultipleParams(UriComponentsBuilder builder, String key, List<String> values) {
		if (values != null && !values.isEmpty()) {
			for (String value : values) {
				builder.queryParam(key, value);
			}
		}
	}

	private void addParamIfNotNull(UriComponentsBuilder builder, String key, String value) {
		if (value != null && !value.isEmpty()) {
			builder.queryParam(key, value);
		}
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	
	
}

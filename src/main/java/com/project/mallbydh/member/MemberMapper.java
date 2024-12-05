package com.project.mallbydh.member;

public interface MemberMapper {

	String idCheck(String u_id);
	
	void join(MemberVO vo);
	
	// 로그인 
	MemberVO login(String u_id);
	
	// 로그인 시 최근 시간 업데이트
	void updateLastLogin(String u_id);
	
	// 회원수정 폼
	MemberVO modifyView(String u_id);
	
	// 회원수정
	void modifySave(MemberVO vo);
	
}

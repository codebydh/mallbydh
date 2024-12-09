package com.project.mallbydh.member;

import org.apache.ibatis.annotations.Param;

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

	// 회원 비밀번호 변경
	void pwchange(@Param("u_id") String u_id, @Param("u_pw") String u_pw);

	// 아이디 찾기
	String idsearch(@Param("u_name") String u_name, @Param("u_email") String u_email);

	// 임시비밀번호 발급을 위한 정보 체크
	String pwtempComfirm(@Param("u_id") String u_id, @Param("u_name") String u_name, @Param("u_email") String u_email);

}

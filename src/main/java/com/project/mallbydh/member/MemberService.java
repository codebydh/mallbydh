package com.project.mallbydh.member;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	public String idCheck(String u_id) {
		return memberMapper.idCheck(u_id);
	}
	
	public void join(MemberVO vo) {
		memberMapper.join(vo);
	}
	
	public MemberVO login(String u_id) {
		return memberMapper.login(u_id);
	}
	
	public void updateLastLogin(String u_id) {
		memberMapper.updateLastLogin(u_id);
	}
	
	public MemberVO modifyView(String u_id) {
		return memberMapper.modifyView(u_id);
	}
	
	public void modifySave(MemberVO vo) {
		memberMapper.modifySave(vo);
	}

}
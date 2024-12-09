package com.project.mallbydh.admin;

public interface AdminMapper {

    // 관리자 로그인
    AdminDTO adLoginPass(String admin_id);

    // 관리자 로그인 시 최근로그인 시간 업데이트
    void updateAdminLastLogin(String admin_id);
}

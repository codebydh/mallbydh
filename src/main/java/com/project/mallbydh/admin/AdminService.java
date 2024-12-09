package com.project.mallbydh.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;

    public AdminDTO adLoginPass(String admin_id) {
        return adminMapper.adLoginPass(admin_id);
    }

    public void updateAdminLastLogin(String admin_id){
        adminMapper.updateAdminLastLogin(admin_id);
    }



}

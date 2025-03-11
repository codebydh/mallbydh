package com.project.mallbydh.admin.member;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AdminMemberService {

    private final AdminMemberMapper adminmembermapper;

    public List<Map<String, Object>> getMembers(SearchCriteria cri, String u_status, String u_gender, String u_emailreceive, String u_smsreceive) {
        return adminmembermapper.getMembers(cri, u_status, u_gender, u_emailreceive, u_smsreceive);
    }

    public int getTotalCount(SearchCriteria cri, String u_status, String u_gender, String u_emailreceive, String u_smsreceive) {
        return adminmembermapper.getTotalCount(cri, u_status, u_gender, u_emailreceive, u_smsreceive);
    }

    public void memberSuspend(String u_id) {
        adminmembermapper.memberSuspend(u_id);
    }

    public void adminUserUpdate(MemberVO vo) {
        adminmembermapper.adminUserUpdate(vo);
    }

}

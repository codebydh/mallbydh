package com.project.mallbydh.admin.member;

import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.member.MemberVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMemberMapper {

    List<Map<String, Object>> getMembers(@Param("cri") SearchCriteria cri, @Param("u_status") String u_status,
                            @Param("u_gender") String u_gender, @Param("u_emailreceive") String u_emailreceive,
                            @Param("u_smsreceive") String u_smsreceive);

    int getTotalCount(@Param("cri") SearchCriteria cri, @Param("u_status") String u_status,
                      @Param("u_gender") String u_gender, @Param("u_emailreceive") String u_emailreceive,
                      @Param("u_smsreceive") String u_smsreceive);

    void memberSuspend(String u_id);

    void adminUserUpdate(MemberVO vo);
}

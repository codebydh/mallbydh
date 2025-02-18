package com.project.mallbydh.admin.manager;

import com.project.mallbydh.common.utils.SearchCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {

    List<AdminVO> getManagers(@Param("cri") SearchCriteria cri, @Param("admin_status") String admin_status);

    int getManagerTotalCount(@Param("cri") SearchCriteria cri, @Param("admin_status") String admin_status);

    void insertManager(AdminVO vo);

    void managerSuspend(String admin_id);

    AdminVO managerEditView(String admin_id);

    void managerUpdate(AdminVO vo);


}

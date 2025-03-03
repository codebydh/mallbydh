package com.project.mallbydh.admin.manager;

import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ManagerService {
    private final ManagerMapper managerMapper;

    public List<AdminVO> getManagers(SearchCriteria cri, String admin_status) {
        return managerMapper.getManagers(cri, admin_status);
    }

    public int getManagerTotalCount(SearchCriteria cri, String admin_status) {
        return managerMapper.getManagerTotalCount(cri, admin_status);
    }

    public void insertManager(AdminVO vo) {
        managerMapper.insertManager(vo);
    }

    public void suspendManager(String admin_id) {
        managerMapper.managerSuspend(admin_id);
    }

    AdminVO managerEditView(String admin_id) {
        return managerMapper.managerEditView(admin_id);
    }

    public void managerUpdate(AdminVO vo) {
        managerMapper.managerUpdate(vo);
    }

}

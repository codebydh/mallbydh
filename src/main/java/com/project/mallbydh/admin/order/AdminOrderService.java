package com.project.mallbydh.admin.order;

import com.project.mallbydh.common.utils.AdminOrderSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AdminOrderService {

    private final AdminOrderMapper adminordermapper;

    public List<Map<String, Object>> getOrderList(AdminOrderSearchCriteria cri) {
        return adminordermapper.getOrderList(cri);
    }

    public int getTotalOrderCount(AdminOrderSearchCriteria cri) {
        return adminordermapper.getTotalOrderCount(cri);
    }

}

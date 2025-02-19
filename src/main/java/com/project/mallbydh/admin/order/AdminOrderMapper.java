package com.project.mallbydh.admin.order;

import com.project.mallbydh.common.utils.AdminOrderSearchCriteria;

import java.util.List;
import java.util.Map;

public interface AdminOrderMapper {

    List<Map<String, Object>> getOrderList(AdminOrderSearchCriteria cri);

    int getTotalOrderCount(AdminOrderSearchCriteria cri);
}

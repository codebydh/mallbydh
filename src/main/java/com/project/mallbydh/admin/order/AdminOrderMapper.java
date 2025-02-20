package com.project.mallbydh.admin.order;

import com.project.mallbydh.common.utils.AdminOrderSearchCriteria;

import java.util.List;
import java.util.Map;

public interface AdminOrderMapper {

    List<Map<String, Object>> getOrderList(AdminOrderSearchCriteria cri);

    int getTotalOrderCount(AdminOrderSearchCriteria cri);

    void orderDirectCancel(Integer ord_code);

    // 주문 변경 시 한번에 사용
    void updateOrder(OrderUpdateDTO dto);
    void updatePayment(OrderUpdateDTO dto);
    void updateDelivery(OrderUpdateDTO dto);
}

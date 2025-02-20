package com.project.mallbydh.admin.order;

import com.project.mallbydh.common.utils.AdminOrderSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void orderDirectCancel(Integer ord_code) {
        adminordermapper.orderDirectCancel(ord_code);
    }

    @Transactional
    public void updateOrderInfo(OrderUpdateDTO dto) {
        adminordermapper.updateOrder(dto);
        adminordermapper.updatePayment(dto);
        adminordermapper.updateDelivery(dto);
    }

}

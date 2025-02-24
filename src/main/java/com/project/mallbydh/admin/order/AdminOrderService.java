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
        if (isAccountTransfer(dto)) {
            adminordermapper.updatePayment(dto);
        }
        adminordermapper.updateDelivery(dto);
    }

    // 무통장입금일 경우에만 payment_tbl update 시행
    private boolean isAccountTransfer(OrderUpdateDTO dto) {
        return dto.getAccount_info() != null || dto.getDeposit_name() != null;
    }

}

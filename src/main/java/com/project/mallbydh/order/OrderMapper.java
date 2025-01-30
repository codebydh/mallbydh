package com.project.mallbydh.order;

import java.util.List;

public interface OrderMapper {

    void insertOrder(OrderVO vo);

    void insertOrderDetail(OrderDetailVO detailVo);

    Integer getOrderByOrdCode(Integer ord_code);

    List<OrderVO> getOrdersByUserId(String u_id);

}

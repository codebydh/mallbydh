package com.project.mallbydh.order;

public interface OrderMapper {

    void insertOrder(OrderVO vo);

    void insertOrderDetail(OrderDetailVO detailVo);

    Integer getOrderByOrdCode(Integer ord_code);

}

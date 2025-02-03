package com.project.mallbydh.order;

import com.project.mallbydh.common.utils.SearchCriteria;

import java.util.List;

public interface OrderMapper {

    void insertOrder(OrderVO vo);

    void insertOrderDetail(OrderDetailVO detailVo);

    Integer getOrderByOrdCode(Integer ord_code);

    List<OrderVO> getOrdersByUserId(String u_id, SearchCriteria cri);

    int getOrderCountByUserId(String u_id, SearchCriteria cri);

}

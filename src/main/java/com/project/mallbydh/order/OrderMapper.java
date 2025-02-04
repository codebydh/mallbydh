package com.project.mallbydh.order;

import com.project.mallbydh.common.utils.SearchCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    void insertOrder(OrderVO vo);

    void insertOrderDetail(OrderDetailVO detailVo);

    Integer getOrderByOrdCode(Integer ord_code);

    List<OrderVO> getOrdersByUserId(String u_id, SearchCriteria cri);

    int getOrderCountByUserId(String u_id, SearchCriteria cri);

    List<Map<String, Object>> getOrderDetailInfo(@Param("ord_code") Integer ord_code);

}

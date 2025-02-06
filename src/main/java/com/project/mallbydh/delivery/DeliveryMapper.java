package com.project.mallbydh.delivery;

public interface DeliveryMapper {

    void insertDelivery(DeliveryVO vo);

    DeliveryVO getDeliveryInfoByOrdCode(Integer ord_code);
}

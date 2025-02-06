package com.project.mallbydh.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliveryService {

    private final DeliveryMapper deliveryMapper;

    public DeliveryVO getDeliveryInfoByOrdCode(Integer ord_code) {
        return deliveryMapper.getDeliveryInfoByOrdCode(ord_code);
    }
}

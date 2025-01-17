package com.project.mallbydh.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderMapper orderMapper;
}

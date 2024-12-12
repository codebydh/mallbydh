package com.project.mallbydh.admin.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdProductService {

    private final AdProductMapper adProductMapper;

    public void pro_insert(ProductVO vo) {
        adProductMapper.pro_insert(vo);
    }
}

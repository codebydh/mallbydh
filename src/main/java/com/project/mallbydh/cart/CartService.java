package com.project.mallbydh.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;

    public void cart_add(CartVO vo) {
        cartMapper.cart_add(vo);
    }
}

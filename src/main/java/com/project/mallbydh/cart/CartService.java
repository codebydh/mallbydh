package com.project.mallbydh.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;

    public void cart_add(CartVO vo) {
        cartMapper.cart_add(vo);
    }

    public List<Map<String, Object>> cart_list(String u_id) {
        return cartMapper.cart_list(u_id);
    }

    public void cart_checkdelete(String u_id, Integer prod_id) {
        cartMapper.cart_checkdelete(u_id, prod_id);
    }

    public void cart_empty(String u_id) {
        cartMapper.cart_empty(u_id);
    }
}

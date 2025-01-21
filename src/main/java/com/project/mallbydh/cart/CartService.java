package com.project.mallbydh.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public int cartUpdate(int cart_amount, int prod_id, String u_id) {
        cartMapper.cartUpdate(cart_amount, prod_id, u_id);
        return cartMapper.getSubtotal(prod_id, u_id);
    }

    public List<Map<String, Object>> getCartDetailsByProdId(Integer prod_id, String u_id) {
        return cartMapper.getCartDetailsByProdId(prod_id, u_id);
    }

    public List<Map<String, Object>> getCartDetailsByUserId(String u_id) {
        return cartMapper.getCartDetailsByUserId(u_id);
    }

    public List<Map<String, Object>> getCartDetailsByProdIds(List<Integer> prod_ids, String u_id) {
        return cartMapper.getCartDetailsByProdIds(prod_ids, u_id);
    }

    // 주문페이지 - 제품의 총 개수
    public int calculateTotalQuantity(List<Map<String, Object>> orderCartDetails) {
        int totalQuantity = 0;
        for (Map<String, Object> detail : orderCartDetails) {
            totalQuantity += ((Number) detail.get("cart_amount")).intValue();
        }
        return totalQuantity;
    }

    // 주문페이지 - 주문 제품의 총 금액
    public int calculateTotalAmount(List<Map<String, Object>> orderCartDetails) {
        int totalAmount = 0;
        for (Map<String, Object> detail : orderCartDetails) {
            Object subtotalObj = detail.get("subtotal");
            if (subtotalObj instanceof Number) {
                totalAmount += ((Number) subtotalObj).intValue();
            }
        }
        return totalAmount;
    }
}

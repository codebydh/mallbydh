package com.project.mallbydh.cart;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

public interface CartMapper {

    void cart_add(CartVO vo);

    List<Map<String, Object>> cart_list(String u_id);

    void cart_checkdelete(@Param("u_id") String u_id, @Param("prod_id") Integer prod_id);

    void cart_empty(String u_id);

    int cartUpdate(@Param("cart_amount") int cart_amount, @Param("prod_id") int prod_id, @Param("u_id") String u_id);

    int getSubtotal(@Param("prod_id") int prod_id, @Param("u_id") String u_id);

    // 아래부터 주문 페이지(order)에서 사용하는 메서드
    // 상품페이지에서 직접 주문 시
    List<Map<String, Object>> getCartDetailsByProdId(Integer prod_id, String u_id);
    // 전체 장바구니 주문 시
    List<Map<String, Object>> getCartDetailsByUserId(String u_id);
    // 장바구니 - 선택 상품 주문 시
    List<Map<String, Object>> getCartDetailsByProdIds(List<Integer> prod_ids, String u_id);

}

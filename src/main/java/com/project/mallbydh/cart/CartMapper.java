package com.project.mallbydh.cart;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CartMapper {

    void cart_add(CartVO vo);

    List<Map<String, Object>> cart_list(String u_id);

    void cart_checkdelete(@Param("u_id") String u_id, @Param("prod_id") Integer prod_id);

    void cart_empty(String u_id);
}

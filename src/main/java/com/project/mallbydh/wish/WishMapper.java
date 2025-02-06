package com.project.mallbydh.wish;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WishMapper {

    List<Integer> getWishListForUser(String u_id);

    int checkWish(@Param("u_id") String u_id, @Param("prod_id") int prod_id);
    void insertWish(@Param("u_id") String u_id, @Param("prod_id") int prod_id);

    int wishRemove(@Param("u_id") String u_id, @Param("prod_id") int prod_id);

    List<Map<String, Object>> getWishListWithProductInfo(String u_id);
}

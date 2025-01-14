package com.project.mallbydh.wish;

import java.util.List;

public interface WishMapper {

    void wishAdd(WishVO vo);

    List<Integer> getWishListForUser(String u_id);

    void wishRemove(String u_id, int prod_id);
}

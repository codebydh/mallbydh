package com.project.mallbydh.wish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class WishService {

    private final WishMapper wishMapper;

    public List<Integer> getWishListForUser(String u_id) {
        return wishMapper.getWishListForUser(u_id);
    }

    public boolean wishRemove(String u_id, int prod_id) {
        int rowsAffected = wishMapper.wishRemove(u_id, prod_id);
        return rowsAffected > 0;
    }

    public boolean addToWish(String u_id, int prod_id) {
        int count = wishMapper.checkWish(u_id, prod_id);
        if (count == 0) {
            wishMapper.insertWish(u_id, prod_id);
            return true;
        }
        return false;
    }

    public List<Map<String, Object>> getUserWishList(String u_id) {
        return wishMapper.getWishListWithProductInfo(u_id);
    }

    public void removeFromWish(String u_id, int prod_id) {
        wishMapper.wishRemove(u_id, prod_id);
    }


}

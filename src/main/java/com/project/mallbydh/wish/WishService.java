package com.project.mallbydh.wish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WishService {

    private final WishMapper wishMapper;

    public void wishAdd(WishVO vo) {
        wishMapper.wishAdd(vo);
    }

    public List<Integer> getWishListForUser(String u_id) {
        return wishMapper.getWishListForUser(u_id);
    }

    public void wishRemove(String u_id, int prod_id) {
        wishMapper.wishRemove(u_id, prod_id);
    }
}

package com.project.mallbydh.wish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WishService {

    private final WishMapper wishMapper;
}

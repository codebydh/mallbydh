package com.project.mallbydh.header;

import com.project.mallbydh.admin.category.CategoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HeaderService {

    private final HeaderMapper headerMapper;

    public List<CategoryVO> getCategoryList() {
        return headerMapper.getCategoryList();
    }

}

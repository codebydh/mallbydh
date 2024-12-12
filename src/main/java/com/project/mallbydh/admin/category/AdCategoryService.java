package com.project.mallbydh.admin.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdCategoryService {

    private final AdCategoryMapper adCategoryMapper;

    public List<CategoryVO> getFirstCategoryList() {
        return adCategoryMapper.getFirstCategoryList();
    }

    public List<CategoryVO> getSecondCategoryList(Integer cate_parentid) {
        return adCategoryMapper.getSecondCategoryList(cate_parentid);
    }

}

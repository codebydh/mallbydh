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

    public CategoryVO getFirstCategoryBySecondCategory(int secondCategory) {
        return adCategoryMapper.getFirstCategoryBySecondCategory(secondCategory);
    }

    public List<Integer> getSubCategoriesByParentId(Integer cate_parentid) {
        return adCategoryMapper.getSubCategoriesByParentId(cate_parentid);
    }

    public CategoryVO getCategoryById(Integer cate_id) {
        return adCategoryMapper.getCategoryById(cate_id);
    }

    public List<CategoryVO> getAllCategories() {
        return adCategoryMapper.getAllCategories();
    }

}

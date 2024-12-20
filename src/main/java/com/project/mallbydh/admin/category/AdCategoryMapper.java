package com.project.mallbydh.admin.category;

import java.util.List;

public interface AdCategoryMapper {

    List<CategoryVO> getFirstCategoryList();
    List<CategoryVO> getSecondCategoryList(Integer cate_parentid);
    CategoryVO getFirstCategoryBySecondCategory(int secondCategory);
    List<Integer> getSubCategoriesByParentId(Integer cate_parentid);
    CategoryVO getCategoryById(Integer cate_id);
    List<CategoryVO> getAllCategories();

}

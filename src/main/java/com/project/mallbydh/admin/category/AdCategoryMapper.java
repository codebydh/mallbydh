package com.project.mallbydh.admin.category;

import java.util.List;

public interface AdCategoryMapper {

    List<CategoryVO> getFirstCategoryList();
    List<CategoryVO> getSecondCategoryList(Integer cate_parentid);
    CategoryVO getFirstCategoryBySecondCategory(int secondCategory);
}

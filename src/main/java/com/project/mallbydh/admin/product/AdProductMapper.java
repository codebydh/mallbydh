package com.project.mallbydh.admin.product;

import com.project.mallbydh.common.utils.SearchCriteria;

import java.util.List;

public interface AdProductMapper {
    void pro_insert(ProductVO vo);

    List<ProductVO> pro_list(SearchCriteria cri) throws Exception;

    int getTotalCount(SearchCriteria cri);
}

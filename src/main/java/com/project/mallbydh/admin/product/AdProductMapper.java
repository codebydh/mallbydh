package com.project.mallbydh.admin.product;

import com.project.mallbydh.common.utils.SearchCriteria;

import java.util.List;

public interface AdProductMapper {
    void pro_insert(ProductVO vo);

    List<ProductVO> pro_list(SearchCriteria cri) throws Exception;

    int getTotalCount(SearchCriteria cri);

    void pro_check_delete(int[] prod_id_arr);

    void pro_delete(Integer prod_id);

    ProductVO pro_edit(Integer prod_id);

    void pro_update(ProductVO vo);
}

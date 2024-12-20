package com.project.mallbydh.product;

import com.project.mallbydh.admin.product.ProductVO;

import java.util.List;

public interface ProductMapper {
    List<ProductVO> getProductsByCateId(Integer cate_id);
    List<ProductVO> getProductsByMultipleCateIds(List<Integer> cate_id);
    List<ProductVO> getAllProducts();
}

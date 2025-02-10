package com.project.mallbydh.product;

import com.project.mallbydh.admin.product.ProductVO;

import java.util.List;

public interface ProductMapper {
    List<ProductVO> getProductsByCateId(Integer cate_id);
    List<ProductVO> getProductsByMultipleCateIds(List<Integer> cate_id);
    List<ProductVO> getAllProducts();
    ProductVO getProductById(Integer prod_id);
    int updateReviewCount(Integer prod_id);
    int updateWishCount(Integer prod_id);
    int updateInquiryCount(Integer prod_id);

    // 주문 테이블에서 활용
    String getProductNameById(Integer prod_id);

    // 메인페이지에서 활용
    List<ProductVO> getLatestProducts();
}

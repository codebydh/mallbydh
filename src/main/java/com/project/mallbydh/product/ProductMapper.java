package com.project.mallbydh.product;

import com.project.mallbydh.admin.product.ProductVO;
import com.project.mallbydh.common.utils.SearchCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    List<ProductVO> getProductsByCateId(Integer cate_id, SearchCriteria cri);
    List<ProductVO> getProductsByMultipleCateIds(@Param("list") List<Integer> cate_id, @Param("cri") SearchCriteria cri);
    List<ProductVO> getAllProducts(SearchCriteria cri);

    int getTotalCountByCateId(Integer cate_id, SearchCriteria cri);
    int getTotalCountByMultipleCateIds(@Param("list") List<Integer> cate_ids, @Param("cri") SearchCriteria cri);
    int getTotalCount(SearchCriteria cri); // 상품페이지에서 활용

    ProductVO getProductById(Integer prod_id);
    int updateReviewCount(Integer prod_id);
    int updateWishCount(Integer prod_id);
    int updateInquiryCount(Integer prod_id);


    // 주문 테이블에서 활용
    String getProductNameById(Integer prod_id);

    // 메인페이지에서 활용
    List<ProductVO> getLatestProducts();
    List<ProductVO> getPromotionProducts();

    // 주문 시 진행되는 작업 (현재 재고에서 차감 및 판매량 반영)
    void subtractProdAmount(ProductVO vo);
    void addProdOrderCount(ProductVO vo);

    // 리뷰, 질문 개수 차감
    void subtractReviewCount(Integer prod_id);
    void subtractInquiryCount(Integer prod_id);

    // 주문 취소 시 누적주문량 차감
    void subtractProductOrderCount(Integer prod_id, Integer ordt_amount);

    // 주문 취소 시 재고 복구
    void addProductStock(Integer prod_id, Integer ordt_amount);
}

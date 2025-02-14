package com.project.mallbydh.product;

import com.project.mallbydh.admin.product.ProductVO;
import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductMapper productMapper;

    public List<ProductVO> getProductsByCateId(Integer cate_id, SearchCriteria cri) {
        return productMapper.getProductsByCateId(cate_id, cri);
    }

    public List<ProductVO> getProductsByMultipleCateIds(List<Integer> cate_id, SearchCriteria cri) {
        return productMapper.getProductsByMultipleCateIds(cate_id, cri);
    }

    public List<ProductVO> getAllProducts(SearchCriteria cri) {
        return productMapper.getAllProducts(cri);
    }

    public int getTotalCountByCateId(Integer cate_id, SearchCriteria cri) {
        return productMapper.getTotalCountByCateId(cate_id, cri);
    }

    public int getTotalCountByMultipleCateIds(List<Integer> cate_id, SearchCriteria cri) {
        return productMapper.getTotalCountByMultipleCateIds(cate_id, cri);
    }

    public int getTotalCount(SearchCriteria cri) {
        return productMapper.getTotalCount(cri);
    }

    public ProductVO getProductById(Integer prod_id) {
        return productMapper.getProductById(prod_id);
    }

    public int updateReviewCount(Integer prod_id) {
        return productMapper.updateReviewCount(prod_id);
    }

    public int updateWishCount(Integer prod_id) {
        return productMapper.updateWishCount(prod_id);
    }

    public int updateInquiryCount(Integer prod_id) {
        return productMapper.updateInquiryCount(prod_id);
    }

    public List<ProductVO> getLatestProducts() {
        return productMapper.getLatestProducts();
    }

}

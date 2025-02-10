package com.project.mallbydh.product;

import com.project.mallbydh.admin.product.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductMapper productMapper;

    public List<ProductVO> getProductsByCateId(Integer cate_id) {
        return productMapper.getProductsByCateId(cate_id);
    }

    public List<ProductVO> getProductsByMultipleCateIds(List<Integer> cate_id) {
        return productMapper.getProductsByMultipleCateIds(cate_id);
    }

    public List<ProductVO> getAllProducts() {
        return productMapper.getAllProducts();
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

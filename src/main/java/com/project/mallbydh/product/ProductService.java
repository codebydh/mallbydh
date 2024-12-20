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
}

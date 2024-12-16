package com.project.mallbydh.admin.product;

import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdProductService {

    private final AdProductMapper adProductMapper;

    public void pro_insert(ProductVO vo) {
        adProductMapper.pro_insert(vo);
    }

    public List<ProductVO> pro_list(SearchCriteria cri) throws Exception {
        return adProductMapper.pro_list(cri);
    }

    public int getTotalCount(SearchCriteria cri) {
        return adProductMapper.getTotalCount(cri);
    }
}

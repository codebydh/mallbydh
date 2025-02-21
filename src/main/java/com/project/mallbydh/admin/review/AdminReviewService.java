package com.project.mallbydh.admin.review;

import com.project.mallbydh.common.utils.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class AdminReviewService {

    private final AdminReviewMapper adminReviewMapper;

    public List<Map<String, Object>> getReviewList(SearchCriteria cri, Integer rev_rate) {
        return adminReviewMapper.getReviewList(cri, rev_rate);
    }

    public int getReviewCount(SearchCriteria cri, Integer rev_rate) {
        return adminReviewMapper.getReviewCount(cri, rev_rate);
    }

    public void reviewDelete(Integer rev_code) {
        adminReviewMapper.reviewDelete(rev_code);
    }
}

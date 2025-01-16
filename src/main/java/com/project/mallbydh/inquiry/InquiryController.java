package com.project.mallbydh.inquiry;

import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
@RestController
public class InquiryController {

    private final InquiryService inquiryService;

    @GetMapping("/inq_list/{prod_id}/{page}")
    public ResponseEntity<Map<String, Object>> inq_list(@PathVariable("prod_id") Integer prod_id, @PathVariable("page") int page) throws Exception {
        ResponseEntity<Map<String, Object>> entity = null;
        Map<String, Object> map = new HashMap<>();

        // 문의 목록
        SearchCriteria cri = new SearchCriteria();
        cri.setPage(page);
        cri.setPerPageNum(5);
        List<InquiryAnswerVO> inq_list = inquiryService.inq_list(prod_id, cri);

        // 문의 페이징 정보
        PageMaker inqPageMaker = new PageMaker();
        inqPageMaker.setCri(cri);
        inqPageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        inqPageMaker.setTotalCount(inquiryService.getInquiryCountByProdId(prod_id));

        map.put("inq_list", inq_list);
        map.put("inqPageMaker", inqPageMaker);

        entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        return entity;
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> inq_save(@RequestBody InquiryAnswerVO vo, HttpSession session) throws Exception {
        ResponseEntity<String> entity = null;

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        vo.setU_id(u_id);
        inquiryService.inquirySave(vo);

        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }
}

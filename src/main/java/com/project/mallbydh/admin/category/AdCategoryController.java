package com.project.mallbydh.admin.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin/category/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class AdCategoryController {

    private final AdCategoryService adCategoryService;

    @GetMapping("/secondcategory/{cate_parentid}") //
    public ResponseEntity<List<CategoryVO>> getSecondCategoryList(@PathVariable("cate_parentid") Integer cate_parentid) {
        ResponseEntity<List<CategoryVO>> entity = null;

        entity = new ResponseEntity<List<CategoryVO>>(adCategoryService.getSecondCategoryList(cate_parentid), HttpStatus.OK);

        return entity;
    }
}

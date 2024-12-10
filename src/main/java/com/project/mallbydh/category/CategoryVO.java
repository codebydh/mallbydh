package com.project.mallbydh.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryVO {

    private Integer cate_id;
    private Integer cate_parentid;
    private String cate_name;
}

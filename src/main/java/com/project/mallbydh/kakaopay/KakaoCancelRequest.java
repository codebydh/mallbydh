package com.project.mallbydh.kakaopay;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class KakaoCancelRequest {
    private String cid;
    private String tid;
    private Integer cancel_amount;
    private Integer cancel_tax_free_amount;
}

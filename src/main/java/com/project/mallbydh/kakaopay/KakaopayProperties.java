package com.project.mallbydh.kakaopay;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@ToString
@Configuration
@PropertySource("classpath:kakaopay/kakaopay.properties")
public class KakaopayProperties {

    @Value("${kakaopay.secretKey}")
    private String secretKey;
    @Value("${kakaopay.cid}")
    private String cid;
}

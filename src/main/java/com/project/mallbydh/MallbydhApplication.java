package com.project.mallbydh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@MapperScan(basePackages = {"com.project.mallbydh.**"}) // mapper 인터페이스가 존재하는 패키지
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // 시큐리티 기능 해제
public class MallbydhApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallbydhApplication.class, args);
    }

}

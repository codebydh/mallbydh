package com.project.mallbydh.common.config;

import com.project.mallbydh.common.interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Component
public class WebMvcConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/cart/**", "/order/**", "/wish/**", "/member/**")
                .excludePathPatterns("/", "/member/login", "/member/join", "/member/idCheck")
                .excludePathPatterns("/order/image_display");
    }
}

package com.project.mallbydh.common.config;

import com.project.mallbydh.common.interceptor.AdminInterceptor;
import com.project.mallbydh.common.interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Component
public class WebMvcConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;
    private final AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/cart/**", "/order/**", "/wish/**", "/member/**")
                .excludePathPatterns("/", "/member/login", "/member/join", "/member/idCheck", "/member/lostpass", "/member/idsearch", "/member/pwtemp")
                .excludePathPatterns("/order/image_display", "/cart/image_display");

        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/", "/admin/adLoginPass", "/admin/product/display/**");
    }
}

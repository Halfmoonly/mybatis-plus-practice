package org.lyflexi.debug_mybatis.config;

import org.lyflexi.debug_mybatis.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: ly
 * @Date: 2024/6/11 21:41
 */
@Configuration
@EnableWebMvc
public class SysWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**") // 指定拦截所有请求
                .excludePathPatterns("/excludePath"); // 排除某些路径不进行拦截
    }
}
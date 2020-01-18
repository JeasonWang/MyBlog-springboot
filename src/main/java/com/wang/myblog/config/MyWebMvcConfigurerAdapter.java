package com.wang.myblog.config;

import com.wang.myblog.interceptor.BackInterceptor;
import com.wang.myblog.interceptor.ForeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getForeInterceptor(){
        return new ForeInterceptor();
    }
    @Bean
    public HandlerInterceptor getBackInterceptor(){
        return new BackInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getBackInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/toLogin");
        registry.addInterceptor(getForeInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin");
    }
}

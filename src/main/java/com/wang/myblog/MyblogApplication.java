package com.wang.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.wang.myblog.dao")
public class MyblogApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }

}

package com.ikeguang.mybatis.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author: keguang
 * @ Date: 2019/6/28 9:31
 * @ version: v1.0.0
 * @ description:
 */

@SpringBootApplication
@MapperScan("com.ikeguang.mybatis.annotation.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

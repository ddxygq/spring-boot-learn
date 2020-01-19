package com.ikeguang.ajax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: keguang
 * @Date: 2019/7/25 10:42
 * @version: v1.0.0
 * @description:
 */
@SpringBootApplication
@MapperScan("com.ikeguang.ajax.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

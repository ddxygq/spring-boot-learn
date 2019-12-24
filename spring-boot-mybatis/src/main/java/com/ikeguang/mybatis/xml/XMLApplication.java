package com.ikeguang.mybatis.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 10:10
 * @ version: v1.0.0
 * @ description:
 */
@SpringBootApplication
@MapperScan("com.ikeguang.mybatis.xml.mapper")
public class XMLApplication {
    public static void main(String[] args) {
        SpringApplication.run(XMLApplication.class);
    }
}

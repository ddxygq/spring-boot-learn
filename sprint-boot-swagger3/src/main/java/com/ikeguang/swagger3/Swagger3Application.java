package com.ikeguang.swagger3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: keguang
 * @Date: 2022/7/22 17:30
 * @version: v1.0.0
 * @description:
 */
@SpringBootApplication
@EnableSwagger2
@EnableOpenApi
public class Swagger3Application {

    public static void main(String[] args) {
        SpringApplication.run(Swagger3Application.class, args) ;
    }
}

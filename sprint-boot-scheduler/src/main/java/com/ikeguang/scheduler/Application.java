package com.ikeguang.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 17:43
 * @ version: v1.0.0
 * @ description: @EnableScheduling 开启定时
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

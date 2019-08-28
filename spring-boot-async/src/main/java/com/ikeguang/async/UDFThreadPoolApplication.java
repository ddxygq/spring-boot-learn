package com.ikeguang.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ Author: keguang
 * @ Date: 2019/8/28 17:27
 * @ version: v1.0.0
 * @ description:
 */
@SpringBootApplication
public class UDFThreadPoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(UDFThreadPoolApplication.class, args);
    }

    @EnableAsync
    @Configuration
    class TaskPoolConfig{

        @Bean("taskExecutor")
        public Executor taskExecutor(){
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(10);;
            executor.setMaxPoolSize(20);
            executor.setQueueCapacity(200);
            executor.setKeepAliveSeconds(60);
            executor.setThreadNamePrefix("taskExecutor-");
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

            return executor;
        }
    }
}

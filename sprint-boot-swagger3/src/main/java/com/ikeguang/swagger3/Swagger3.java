package com.ikeguang.swagger3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: keguang
 * @Date: 2022/7/22 17:41
 * @version: v1.0.0
 * @description:
 */
@Configuration
public class Swagger3 {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot 应用")
                        .version("v1.0")
                        .description("Swagger3.0 测试")
                        .contact(new Contact("ikeguang.com", "https://www.ikeguang.com/", "ikeguang@126.com"))
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ikeguang.swagger3.controller"))
                .build();

    }
}

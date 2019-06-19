package com.ikeguang.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author: keguang
 * @ Date: 2019/6/19 19:57
 * @ version: v1.0.0
 * @ description:
 */

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }
}

package com.ikeguang.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author: keguang
 * @ Date: 2019/8/20 15:24
 * @ version: v1.0.0
 * @ description:
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

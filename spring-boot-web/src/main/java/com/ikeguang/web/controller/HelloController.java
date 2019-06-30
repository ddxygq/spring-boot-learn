package com.ikeguang.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @ Author: keguang
 * @ Date: 2019/6/19 20:26
 * @ version: v1.0.0
 * @ description:
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Locale locale, Model model){
        return "Hello World";
    }
}

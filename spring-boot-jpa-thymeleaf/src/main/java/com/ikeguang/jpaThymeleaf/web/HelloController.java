package com.ikeguang.jpaThymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author: keguang
 * @ Date: 2019/7/18 10:29
 * @ version: v1.0.0
 * @ description:
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "world") String name){
        model.addAttribute("name", name);

        return "hello";
    }
}

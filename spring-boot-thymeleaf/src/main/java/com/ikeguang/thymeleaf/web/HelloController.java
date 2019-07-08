package com.ikeguang.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author: keguang
 * @ Date: 2019/7/8 13:50
 * @ version: v1.0.0
 * @ description:
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("message", "http://www.ikeguang.com/mapsite.xml");
        return "hello";
    }
}

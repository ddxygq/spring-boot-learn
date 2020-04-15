package com.ikeguang.echarts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: keguang
 * @Date: 2020/4/15 17:02
 * @version: v1.0.0
 * @description:
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String index(ModelMap map){
        return "index";
    }
}

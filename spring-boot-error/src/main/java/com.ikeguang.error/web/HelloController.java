package com.ikeguang.error.web;

import com.ikeguang.error.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author: keguang
 * @ Date: 2019/8/6 10:20
 * @ version: v1.0.0
 * @ description:
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host", "http://www.ikeguang.com");
        return "index";
    }

}

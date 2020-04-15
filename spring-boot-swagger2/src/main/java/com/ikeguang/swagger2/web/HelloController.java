package com.ikeguang.swagger2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author: keguang
 * @Date: 2019/7/30 17:42
 * @version: v1.0.0
 * @description:
 */

@RestController
public class HelloController {

    @ApiIgnore
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){
        return "Hello World";
    }
}

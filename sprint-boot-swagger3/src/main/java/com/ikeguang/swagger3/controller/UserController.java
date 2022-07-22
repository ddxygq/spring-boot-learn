package com.ikeguang.swagger3.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: keguang
 * @Date: 2022/7/22 18:25
 * @version: v1.0.0
 * @description:
 */
@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    @ApiOperation("查询用户")
    public String list() {
        return "查询成功";
    }

}

package com.ikeguang.vue.web;

import com.ikeguang.vue.result.Result;
import com.ikeguang.vue.service.UserService;
import com.ikeguang.vue.utils.ResultConfigFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: keguang
 * @Date: 2019/7/18 10:29
 * @version: v1.0.0
 * @description:
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("获取用户列表")
    @GetMapping("/users")
    public Result list(){
        return ResultConfigFactory.builtResult(userService.getUserList());
    }
}

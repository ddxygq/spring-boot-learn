package com.ikeguang.vue.service;

import com.ikeguang.vue.model.User2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: keguang
 * @Date: 2021/1/26 15:05
 * @version: v1.0.0
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class User2ServiceTests {

    @Autowired
    UserService userService;

    @Test
    public void saveUserTest(){
        for(long i = 10;i < 50; i++){
            User2 user = new User2(i, String.format("柯广 %s", i), String.format("keguang%s", i));
            userService.saveUser(user);
        }

    }

    @Test
    public void getUserList(){
        List<User2> user2List = userService.getUserList();
        System.out.println(user2List);
    }
}

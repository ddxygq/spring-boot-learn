package com.ikeguang.mybatis.xml.web;

import com.ikeguang.mybatis.xml.mapper.UserMapper;
import com.ikeguang.mybatis.xml.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 10:56
 * @ version: v1.0.0
 * @ description:
 */

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/xml/getUsers")
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping("/xml/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/xml/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="/xml/update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/xml/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}

package com.ikeguang.jpaThymeleaf.service;

import com.ikeguang.jpaThymeleaf.model.User;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/18 10:26
 * @ version: v1.0.0
 * @ description:
 */
public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);
}

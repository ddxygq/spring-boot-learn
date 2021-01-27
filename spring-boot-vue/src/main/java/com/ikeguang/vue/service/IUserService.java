package com.ikeguang.vue.service;

import com.ikeguang.vue.model.User2;

import java.util.List;

/**
 * @Author: keguang
 * @Date: 2019/7/18 10:26
 * @version: v1.0.0
 * @description:
 */
public interface IUserService {

    List<User2> getUserList();

    User2 findUserById(long id);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User2 user);
}

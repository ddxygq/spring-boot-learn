package com.ikeguang.mybatis.xml.mapper;

import com.ikeguang.mybatis.xml.model.User;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 9:53
 * @ version: v1.0.0
 * @ description:
 */
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}

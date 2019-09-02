package com.ikeguang.paging.service;

import com.ikeguang.paging.model.User;
import org.springframework.data.domain.Page;

import java.util.Iterator;

/**
 * @ Author: keguang
 * @ Date: 2019/7/18 10:26
 * @ version: v1.0.0
 * @ description:
 */
public interface UserService {

    public Page<User> getUserList(int pageNum, int pageSize);

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);
}

package com.ikeguang.paging.service;

import com.ikeguang.paging.model.User;
import org.springframework.data.domain.Page;


/**
 * @ Author: keguang
 * @ Date: 2019/7/18 10:26
 * @ version: v1.0.0
 * @ description:
 */
public interface UserService {

    Page<User> getUserList(int pageNum, int pageSize);

    User findUserById(long id);

    void save(User user);

    void edit(User user);

    void delete(long id);
}

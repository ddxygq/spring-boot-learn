package com.ikeguang.web.repository;

import com.ikeguang.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author: keguang
 * @ Date: 2019/6/24 20:23
 * @ version: v1.0.0
 * @ description:
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);

}

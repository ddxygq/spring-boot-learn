package com.ikeguang.jpaThymeleaf.repository;

import com.ikeguang.jpaThymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/18 10:23
 * @ version: v1.0.0
 * @ description:
 */
public interface UserRepository extends JpaRepository<User, Long>{

    User findById(long id);

    void deleteById(long id);
}

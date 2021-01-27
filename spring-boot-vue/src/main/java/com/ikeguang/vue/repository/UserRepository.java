package com.ikeguang.vue.repository;

import com.ikeguang.vue.model.User2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: keguang
 * @Date: 2019/7/18 10:23
 * @version: v1.0.0
 * @description:
 */
public interface UserRepository extends JpaRepository<User2, Long>{

    User2 findById(long id);
}

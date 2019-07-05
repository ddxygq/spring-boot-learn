package com.ikeguang.jpa.repository;

import com.ikeguang.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 16:47
 * @ version: v1.0.0
 * @ description:
 */
public interface UserMutiRepository extends JpaRepository<User, Long>{

    @Override
    Page<User> findAll(Pageable pageable);

    Page<User> findByUserName(String userName, Pageable pageable);

}

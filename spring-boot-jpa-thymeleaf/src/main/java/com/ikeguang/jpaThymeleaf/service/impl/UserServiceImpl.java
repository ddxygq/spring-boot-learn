package com.ikeguang.jpaThymeleaf.service.impl;

import com.github.pagehelper.Page;
import com.ikeguang.jpaThymeleaf.model.User;
import com.ikeguang.jpaThymeleaf.repository.UserRepository;
import com.ikeguang.jpaThymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author: keguang
 * @ Date: 2019/7/18 10:27
 * @ version: v1.0.0
 * @ description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {

        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}

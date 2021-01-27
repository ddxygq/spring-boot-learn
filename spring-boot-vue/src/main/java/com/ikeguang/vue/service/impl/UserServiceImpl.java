package com.ikeguang.vue.service.impl;

import com.ikeguang.vue.model.User2;
import com.ikeguang.vue.repository.UserRepository;
import com.ikeguang.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: keguang
 * @Date: 2019/7/18 10:27
 * @version: v1.0.0
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User2> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User2 findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(User2 user) {
        userRepository.save(user);
    }
}

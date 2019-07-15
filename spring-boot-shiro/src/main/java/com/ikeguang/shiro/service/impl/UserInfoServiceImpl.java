package com.ikeguang.shiro.service.impl;

import com.ikeguang.shiro.dao.UserInfoDao;
import com.ikeguang.shiro.model.UserInfo;
import com.ikeguang.shiro.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ Author: keguang
 * @ Date: 2019/7/15 16:44
 * @ version: v1.0.0
 * @ description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
package com.ikeguang.shiro.service;

import com.ikeguang.shiro.model.UserInfo;

/**
 * @ Author: keguang
 * @ Date: 2019/7/15 16:43
 * @ version: v1.0.0
 * @ description:
 */
public interface UserInfoService {

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}

package com.ikeguang.shiro.dao;

import com.ikeguang.shiro.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @ Author: keguang
 * @ Date: 2019/7/15 16:37
 * @ version: v1.0.0
 * @ description:
 */
public interface UserInfoDao extends CrudRepository<UserInfo, Long>{

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}

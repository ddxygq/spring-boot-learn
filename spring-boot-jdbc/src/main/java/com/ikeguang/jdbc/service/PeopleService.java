package com.ikeguang.jdbc.service;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 10:37
 * @ version: v1.0.0
 * @ description:
 */
public interface PeopleService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取所有用户
     */
    Integer getAllPeoples();

    /**
     * 删除所有用户
     */
    void deleteAllPeople();
}

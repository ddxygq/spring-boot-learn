package com.ikeguang.jdbc.service.impl;

import com.ikeguang.jdbc.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 10:44
 * @ version: v1.0.0
 * @ description:
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {

        jdbcTemplate.update("insert into people(name, age) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from people where name = ?", name);
    }

    @Override
    public Integer getAllPeoples() {
        return jdbcTemplate.queryForObject("select count(1) from people", Integer.class);
    }

    @Override
    public void deleteAllPeople() {
        jdbcTemplate.update("delete from people");
    }
}

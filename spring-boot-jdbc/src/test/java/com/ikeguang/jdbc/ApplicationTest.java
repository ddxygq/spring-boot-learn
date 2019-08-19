package com.ikeguang.jdbc;

import com.ikeguang.jdbc.service.PeopleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 10:52
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private PeopleService peopleService;

    @Before
    public void setUp(){
        peopleService.deleteAllPeople();
    }

    @Test
    public void test(){
        peopleService.create("a", 1);
        peopleService.create("b", 2);
        peopleService.create("c", 3);
        peopleService.create("d", 4);
        peopleService.create("e", 5);
        peopleService.create("f", 6);
        peopleService.create("g", 7);

        // 查询
        Assert.assertEquals(7, peopleService.getAllPeoples().intValue());

        // 删除
        peopleService.deleteByName("a");
        peopleService.deleteByName("b");

        Assert.assertEquals(5, peopleService.getAllPeoples().intValue());

        System.out.println("test finished...");


    }


}

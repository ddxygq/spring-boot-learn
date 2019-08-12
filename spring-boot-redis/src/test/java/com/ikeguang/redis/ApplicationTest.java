package com.ikeguang.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author: keguang
 * @ Date: 2019/8/12 15:59
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("name", "keguang");
        Assert.assertEquals("keguang", stringRedisTemplate.opsForValue().get("name"));
    }
}

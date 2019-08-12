package com.ikeguang.config;

import com.ikeguang.config.model.BlogProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author: keguang
 * @ Date: 2019/8/12 17:11
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getHello(){
        System.out.println(blogProperties.getName());
    }
}

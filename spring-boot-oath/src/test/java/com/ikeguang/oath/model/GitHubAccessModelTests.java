package com.ikeguang.oath.model;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GitHubAccessModelTests {

    @Autowired
    GitHubAccessModel gitHubAccessModel;

    @Test
    public void test(){
        System.out.println(gitHubAccessModel);
        JSON.toJSONString(gitHubAccessModel);
    }
}

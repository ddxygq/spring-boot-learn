package com.ikeguang.mybatis.annotation.mapper;

import com.ikeguang.mybatis.annotation.enums.UserSexEnum;
import com.ikeguang.mybatis.annotation.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/1 17:35
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception{
        userMapper.insert(new User("aa1", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb1", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc1", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery(){
        List<User> users = userMapper.getAll();
        for(User user : users){
            System.out.println(user.toString());
        }
    }

    @Test
    public void testQueryOne(){
        User user = userMapper.getOne(1L);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = userMapper.getOne(2L);
        System.out.println(user.toString());

        user.setNickName("ikeguang");
        userMapper.update(user);

        Assert.assertTrue("ikeguang".equals(userMapper.getOne(2L).getNickName()));
    }

}

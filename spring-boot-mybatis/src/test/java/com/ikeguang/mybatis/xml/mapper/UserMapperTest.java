package com.ikeguang.mybatis.xml.mapper;

import com.ikeguang.mybatis.annotation.enums.UserSexEnum;

import com.ikeguang.mybatis.xml.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 10:04
 * @ version: v1.0.0
 * @ description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        if(users==null || users.size()==0){
            System.out.println("is null");
        }else{
            System.out.println(users.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(6l);
        System.out.println(user.toString());
        user.setNickName("neo");
        userMapper.update(user);
        Assert.assertTrue(("neo".equals(userMapper.getOne(6l).getNickName())));
    }

    @Test
    public void testDelete(){
        userMapper.delete(1L);
        userMapper.delete(2L);
        userMapper.delete(3L);
    }


}

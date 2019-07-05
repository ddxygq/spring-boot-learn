package com.ikeguang.mybatis.annotation.mapper;

import com.ikeguang.mybatis.annotation.enums.UserSexEnum;
import com.ikeguang.mybatis.annotation.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/1 16:59
 * @ version: v1.0.0
 * @ description:
 */
public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}

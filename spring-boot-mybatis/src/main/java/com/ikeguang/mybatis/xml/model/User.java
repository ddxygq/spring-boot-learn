package com.ikeguang.mybatis.xml.model;

import com.ikeguang.mybatis.annotation.enums.UserSexEnum;

import java.io.Serializable;

/**
 * @ Author: keguang
 * @ Date: 2019/7/1 16:33
 * @ version: v1.0.0
 * @ description:
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;

    public User() {
    }

    public User(String userName, String passWord, UserSexEnum userSex) {
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userSex=" + userSex +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

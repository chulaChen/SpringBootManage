package com.chenzhuo.model;

import javax.persistence.Entity;

/**
 * User: cz
 * Date: 2017/12/27
 * Time: 10:43
 */
@Entity
public class User {

    private Long id;

    private String userName;

    private String userPwd;

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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}

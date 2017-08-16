package com.mitch.bean;

import java.io.Serializable;

public class Tuser implements Serializable{
    private Integer userId;

    private String userName;

    private String password;

    private String userAccout;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserAccout() {
        return userAccout;
    }

    public void setUserAccout(String userAccout) {
        this.userAccout = userAccout == null ? null : userAccout.trim();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tuser{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", userAccout='").append(userAccout).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
package com.mitch.param;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/18.
 */
public class UserResponseParam implements Serializable {
    private String loginInfo;
    private String name;

    public String getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(String loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

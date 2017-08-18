package com.mitch.param;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/18.
 */
public class UserRequestParam extends APIParam implements Serializable{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

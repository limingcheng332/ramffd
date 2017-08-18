package com.mitch.apis;

import com.mitch.annotation.RamffdAPI;
import com.mitch.annotation.RamffdFunction;
import com.mitch.param.UserRequestParam;
import com.mitch.param.UserResponseParam;

import javax.annotation.Resource;

/**
 * Created by limc on 2017/8/16.
 */
@RamffdAPI("USER")
public class UserAPI {
    @RamffdFunction(value = "00003",explain = "用户登录")
    public UserResponseParam login(UserRequestParam param){
        UserResponseParam responseParam = new UserResponseParam();
        responseParam.setLoginInfo("yes");
        responseParam.setName(param.getName());
        return responseParam;
    }

    @RamffdFunction(value = "00002",explain = "获取用户列表")
    public Object getUserList(Object user){
        return null;
    }
}

package com.mitch.apis;

import com.mitch.annotation.RamffdAPI;
import com.mitch.annotation.RamffdFunction;
import com.mitch.base.BaseAPI;
import com.mitch.param.UserRequestParam;
import com.mitch.param.UserResponseParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by limc on 2017/8/16.
 */
@RamffdAPI("USER")
@Component
public class UserAPI extends BaseAPI{
    @RamffdFunction(value = "00003",explain = "用户登录")
    public UserResponseParam login(UserRequestParam param){
        UserResponseParam responseParam = new UserResponseParam();
        responseParam.setLoginInfo("yes");
        responseParam.setName(param.getName());
        return responseParam;
    }

    @RamffdFunction(value = "00002",explain = "获取用户列表")
    public UserResponseParam getUserList(UserRequestParam user){
        return new UserResponseParam();
    }
}

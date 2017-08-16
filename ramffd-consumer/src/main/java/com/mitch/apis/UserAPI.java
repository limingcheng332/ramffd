package com.mitch.apis;

import com.mitch.annotation.RamffdAPI;
import com.mitch.annotation.RamffdFunction;
import com.mitch.bean.Tuser;
import com.mitch.service.TuserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by limc on 2017/8/16.
 */
@RamffdAPI("USER")
@Component
public class UserAPI {
    @Resource
    private TuserService tuserService;
    @RamffdFunction(value = "00001",explain = "用户登录")
    public Tuser login(Tuser user){
        tuserService.getUser(user);
        return null;
    }

    @RamffdFunction(value = "00002",explain = "获取用户列表")
    public Tuser getUserList(Tuser user){
        tuserService.getUser(user);
        return null;
    }
}

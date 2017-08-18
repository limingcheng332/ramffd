package com.mitch.netty.massage;

import java.io.Serializable;

/**
 * 请求包装
 * Created by limc on 2017/8/17.
 */
public class Request extends Message implements Serializable{

    private String originStr;//原始串

    public String getOriginStr() {
        return originStr;
    }

    public void setOriginStr(String originStr) {
        this.originStr = originStr;
    }
}

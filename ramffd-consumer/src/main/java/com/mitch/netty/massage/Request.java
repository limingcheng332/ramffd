package com.mitch.netty.massage;

import java.io.Serializable;

/**
 * 请求包装
 * Created by limc on 2017/8/17.
 */
public class Request implements Serializable{
    private String moduleId;    //模块信息
    private String functionNo;//功能号
    private String data;//json数据
    private String originStr;//原始串

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getFunctionNo() {
        return functionNo;
    }

    public void setFunctionNo(String functionNo) {
        this.functionNo = functionNo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOriginStr() {
        return originStr;
    }

    public void setOriginStr(String originStr) {
        this.originStr = originStr;
    }
}

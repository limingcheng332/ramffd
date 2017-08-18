package com.mitch.netty.massage;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/18.
 */
public class Message implements Serializable{
    private String moduleId;    //模块信息
    private String functionNo;//功能号
    private String data;//json数据

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
}

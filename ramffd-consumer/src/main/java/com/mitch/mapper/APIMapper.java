package com.mitch.mapper;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 请求映射
 * Created by limc on 2017/8/16.
 */
public class APIMapper implements Serializable{
    private String apiName;
    private String functionNo;
    private Class clazz;
//    private Method method;
    private String explain;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getFunctionNo() {
        return functionNo;
    }

    public void setFunctionNo(String functionNo) {
        this.functionNo = functionNo;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

//    public Method getMethod() {
//        return method;
//    }
//
//    public void setMethod(Method method) {
//        this.method = method;
//    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getPath(String apiName, String functionNo){
        return apiName + "::" + functionNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("APIMapper{");
        sb.append("apiName='").append(apiName).append('\'');
        sb.append(", functionNo='").append(functionNo).append('\'');
        sb.append(", clazz=").append(clazz);
        sb.append(", explain='").append(explain).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

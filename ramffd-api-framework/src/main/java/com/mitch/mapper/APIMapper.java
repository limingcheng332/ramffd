package com.mitch.mapper;

import com.mitch.constants.APIConstants;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 请求映射
 * Created by limc on 2017/8/16.
 */
public class APIMapper implements Serializable{
    private String apiName;//模块名
    private String functionNo;//功能号
    private Class clazz;//执行的类名
    private String methodName;//执行的方法名
    private String explain;//接口说明
    private Class<?>[] parameterTypes;//参数类型

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

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getPath(String apiName, String functionNo){
        return apiName + APIConstants.MSG_SPLIT + functionNo;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("APIMapper{");
        sb.append("apiName='").append(apiName).append('\'');
        sb.append(", functionNo='").append(functionNo).append('\'');
        sb.append(", clazz=").append(clazz);
        sb.append(", methodName='").append(methodName).append('\'');
        sb.append(", explain='").append(explain).append('\'');
        sb.append(", parameterTypes=").append(Arrays.toString(parameterTypes));
        sb.append('}');
        return sb.toString();
    }
}

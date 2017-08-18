package com.mitch.param;

import com.mitch.base.BaseAPI;
import com.mitch.interceptor.ApiInterceptor;

import java.lang.reflect.Method;

/**
 * api执行信息
 */
public class ExecuteApiInfo {
    private String module;
    private String function;
    private APIParam apiParam;//入参
    private Method method;//方法
    private BaseAPI api;//类的实例


    public APIParam getApiParam() {
        return apiParam;
    }

    public void setApiParam(APIParam apiParam) {
        this.apiParam = apiParam;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public BaseAPI getApi() {
        return api;
    }

    public void setApi(BaseAPI api) {
        this.api = api;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}

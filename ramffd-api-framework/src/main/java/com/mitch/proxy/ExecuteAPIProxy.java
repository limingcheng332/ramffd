package com.mitch.proxy;

import com.mitch.annotation.Interceptor;
import com.mitch.chain.ExecuteAPI;
import com.mitch.constants.APIConstants;
import com.mitch.exception.APIException;
import com.mitch.helper.APIHelper;
import com.mitch.interceptor.ApiInterceptor;
import com.mitch.param.APIParam;
import com.mitch.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * api执行代理,用于api拦截器实现
 * Created by Administrator on 2017/8/18.
 */
public class ExecuteAPIProxy {
    private ExecuteAPI executeAPI;

    private List<ApiInterceptor> interceptors = new ArrayList<ApiInterceptor>();

    public ExecuteAPI getExecuteAPI() {
        return executeAPI;
    }

    public void setExecuteAPI(ExecuteAPI executeAPI) {
        this.executeAPI = executeAPI;
    }

    public APIParam execute(){
        //筛选出这个接口的拦截器
        try {
            initInterceptors();
        } catch (Exception e) {
            throw new APIException(APIConstants.SYS_EXCEPTION,"初始化拦截器异常",e);
        }
        //执行前置拦截
        executePreInterceptors();
        //执行被拦截的方法
        APIParam resultParam = executeAPI.handle();
        //执行后置拦截
        executePostInterceptors(executeAPI.getExecuteApiInfo().getApiParam(),resultParam);
        interceptors.clear();
        interceptors = null;
        return resultParam;
    }

    /**
     * 筛选拦截器，支持@Interceptor注解
     */
    private void initInterceptors() throws IllegalAccessException, InstantiationException {
        Set<Class<?> > classes = APIHelper.getInterceptorClassSet();
        //类名
        for (Class<?> clz : classes){
            Interceptor annotation = clz.getAnnotation(Interceptor.class);
            String[] strings = annotation.classes();
            for(String str : strings){
                String[] moduleAndFunction = str.split("/");
                //如果拦截器注解中的模块和功能号能匹配，就添加进拦截器列表
                if(executeAPI.getExecuteApiInfo().getModule().equals(moduleAndFunction[0])
                        && executeAPI.getExecuteApiInfo().getFunction().equals(moduleAndFunction[1])){

                    interceptors.add((ApiInterceptor) clz.newInstance());

                }
            }
        }
    }

    private void executePreInterceptors() {
        if(interceptors != null){
            for (ApiInterceptor interceptor : interceptors){
                interceptor.preInterceptor(executeAPI.getExecuteApiInfo().getApiParam());
            }
        }

    }

    private void executePostInterceptors(APIParam request,APIParam result) {
        if(interceptors != null) {
            for (ApiInterceptor interceptor : interceptors) {
                interceptor.postInterceptor(request, result);
            }
        }
    }
}

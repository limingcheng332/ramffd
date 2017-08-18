package com.mitch.interceptor;

import com.mitch.param.APIParam;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface ApiInterceptor {
    void preInterceptor(APIParam param);
    void postInterceptor(APIParam request,APIParam result);
}

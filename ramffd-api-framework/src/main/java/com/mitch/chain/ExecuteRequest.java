package com.mitch.chain;

import com.mitch.base.BaseAPI;
import com.mitch.constants.APIConstants;
import com.mitch.exception.APIException;
import com.mitch.mapper.APIMapper;
import com.mitch.netty.massage.Request;
import com.mitch.param.APIParam;
import com.mitch.param.ExecuteApiInfo;
import com.mitch.proxy.ExecuteAPIProxy;
import com.mitch.utils.SpringContextUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/8/18.
 */
@Component
public class ExecuteRequest implements Chain{
    private APIMapper apiMapper;
    private Request request;
    private APIParam apiParam;
    @Resource
    private ExecuteAPI executeAPI;

    public APIMapper getApiMapper() {
        return apiMapper;
    }

    public void setApiMapper(APIMapper apiMapper) {
        this.apiMapper = apiMapper;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public APIParam handle()  {
        APIParam resultParam;
        Class mapperClass = apiMapper.getClazz();
        BaseAPI api = SpringContextUtil.getBean(mapperClass);
        Class paramType = apiMapper.getParameterTypes()[0];
        Method method;
        try {
            method = mapperClass.getDeclaredMethod(apiMapper.getMethodName(),apiMapper.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new APIException(APIConstants.BUSI_EXCEPTION,"api没有此接口",e);
        }
        apiParam = (APIParam) JSONObject.toBean(JSONObject.fromString(request.getData()),paramType);
        //获取执行信息
        ExecuteApiInfo executeApiInfo = new ExecuteApiInfo();
        executeApiInfo.setApi(api);
        executeApiInfo.setApiParam(apiParam);
        executeApiInfo.setMethod(method);
        executeApiInfo.setModule(apiMapper.getApiName());
        executeApiInfo.setFunction(apiMapper.getFunctionNo());
        executeAPI.setExecuteApiInfo(executeApiInfo);
        //使用代理进行拦截
        ExecuteAPIProxy proxy = new ExecuteAPIProxy();
        proxy.setExecuteAPI(executeAPI);
        resultParam = proxy.execute();
        return resultParam;
    }

}

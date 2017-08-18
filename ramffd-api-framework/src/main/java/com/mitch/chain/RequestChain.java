package com.mitch.chain;

import com.mitch.constants.APIConstants;
import com.mitch.exception.APIException;
import com.mitch.mapper.APIMapper;
import com.mitch.netty.massage.Request;
import com.mitch.netty.massage.Response;
import com.mitch.netty.massage.ResponseDecoder;
import com.mitch.param.APIParam;
import com.mitch.redis.RedisUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/8/18.
 */
@Component
public class RequestChain implements Chain{
    private Request request;
    @Resource
    private ExecuteRequest executeRequest;
    @Resource
    private RedisUtil redisUtil;
    private ResponseDecoder responseDecoder;
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public Response handle() {
        String redisPath = request.getModuleId() + APIConstants.MSG_SPLIT + request.getFunctionNo();
        APIMapper apiMapper = (APIMapper) redisUtil.get(redisPath);
        if (apiMapper == null){
            throw new APIException(APIConstants.BUSI_EXCEPTION,"无对应的接口...");
        }
        executeRequest.setApiMapper(apiMapper);
        executeRequest.setRequest(request);
        APIParam responseParam =  executeRequest.handle();

        JSONObject data = JSONObject.fromBean(responseParam);
        if(data == null){
            throw new APIException(APIConstants.BUSI_EXCEPTION,"返回的数据有问题");
        }
        Response response = new Response();
        response.setModuleId(request.getModuleId());
        response.setFunctionNo(request.getFunctionNo());
        response.setData(data.toString());
        return response;
    }
}

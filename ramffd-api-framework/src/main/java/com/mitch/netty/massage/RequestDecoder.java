package com.mitch.netty.massage;

import com.mitch.constants.APIConstants;
import com.mitch.exception.APIException;
import com.mitch.utils.StringUtil;
import net.sf.json.JSONObject;
import net.sf.json.JSONStringer;
import net.sf.json.JSONUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/17.
 */
@Component
public class RequestDecoder implements Decoder<Request>{

    @Override
    public Request decode(String message) {
        if(!validate(message)){
            throw new APIException(APIConstants.BUSI_EXCEPTION,"非API请求!");
        }
        String[] elements = message.split(APIConstants.MSG_SPLIT);

        Request request = new Request();
        request.setModuleId(elements[0]);//模块id
        request.setFunctionNo(elements[1]);//功能号
        request.setOriginStr(message);//原始串
        request.setData(elements[2]);//json串
        return request;
    }

    @Override
    public String encode(Request message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message.getModuleId()).append(APIConstants.MSG_SPLIT);
        stringBuilder.append(message.getFunctionNo()).append(APIConstants.MSG_SPLIT);
        stringBuilder.append(message.getData()).append(APIConstants.MSG_END);
        return stringBuilder.toString();
    }


    /**
     * 验证是否为api请求
     * @param message
     * @return
     */
    private boolean validate(String message){
        if(StringUtil.isBlank(message)){
            return false;
        }
        if(StringUtil.appearNumber(message,APIConstants.MSG_SPLIT) != 2){
            return false;
        }
        String[] strs = message.split(APIConstants.MSG_SPLIT);
        try{
            JSONObject.fromObject(strs[2]);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}

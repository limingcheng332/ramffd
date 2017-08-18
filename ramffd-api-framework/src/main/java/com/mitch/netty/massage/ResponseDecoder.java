package com.mitch.netty.massage;

import com.mitch.constants.APIConstants;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/18.
 */
@Component
public class ResponseDecoder implements Decoder<Response> {
    @Override
    public Response decode(String message) {
        return null;
    }

    @Override
    public String encode(Response message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message.getModuleId()).append(APIConstants.MSG_SPLIT);
        stringBuilder.append(message.getFunctionNo()).append(APIConstants.MSG_SPLIT);
        stringBuilder.append(message.getErrcode()).append(APIConstants.MSG_SPLIT);
        stringBuilder.append(message.getErrmsg()).append(APIConstants.MSG_SPLIT);
        stringBuilder.append(message.getData()).append(APIConstants.MSG_END);
        return stringBuilder.toString();
    }
}

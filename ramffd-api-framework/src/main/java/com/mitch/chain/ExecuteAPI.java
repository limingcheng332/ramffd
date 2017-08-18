package com.mitch.chain;

import com.mitch.constants.APIConstants;
import com.mitch.exception.APIException;
import com.mitch.param.APIParam;
import com.mitch.param.ExecuteApiInfo;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/18.
 */
@Component
public class ExecuteAPI implements Chain {
    private ExecuteApiInfo executeApiInfo;

    public ExecuteApiInfo getExecuteApiInfo() {
        return executeApiInfo;
    }

    public void setExecuteApiInfo(ExecuteApiInfo executeApiInfo) {
        this.executeApiInfo = executeApiInfo;
    }

    @Override
    public APIParam handle() {
        APIParam resultParam;
        try {
            resultParam = (APIParam) executeApiInfo.getMethod().invoke(executeApiInfo.getApi(),executeApiInfo.getApiParam());
        } catch (Exception e) {
            throw new APIException(APIConstants.SYS_EXCEPTION,String.format("方法[%s]执行异常",executeApiInfo.getMethod().getName()),e);
        }
        return resultParam;
    }
}

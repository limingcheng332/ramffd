package com.mitch.config;

import com.mitch.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/16.
 */
@Component
public class ServerConfigBean {
    @Value("#{configProperties['server.ip']}")
    private String serverIp;
    @Value("#{configProperties['server.port']}")
    private String serverPort;
    @Value("#{configProperties['api.basepackage']}")
    private String apiBasepackage;


    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getApiBasepackage() {
        return apiBasepackage;
    }

    public void setApiBasepackage(String apiBasepackage) {
        this.apiBasepackage = apiBasepackage;
    }


    public static ServerConfigBean getConfigBean(){
        return SpringContextUtil.getBean("serverConfigBean");
    }
}

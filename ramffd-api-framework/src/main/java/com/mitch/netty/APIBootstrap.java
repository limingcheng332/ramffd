package com.mitch.netty;

import com.mitch.helper.APIHelper;
import com.mitch.utils.SpringContextUtil;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * api启动类
 * Created by limc on 2017/8/16.
 */
public class APIBootstrap {
    private static Logger logger = Logger.getLogger(APIBootstrap.class);

    public static void main(String[] args) {
        //启动上下文
        logger.info("-----------------------------API服务正在启动-----------------------------");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        context.start();

        logger.info("-------------------------------正在加载api接口---------------------------");
        APIHelper.init();
        logger.info("-------------------------------正在启动端口-----------------------------");
        APIServer apiServer = SpringContextUtil.getBean("APIServer");
        apiServer.start();
    }
}

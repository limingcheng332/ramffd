package com.mitch.dubbo;

import com.mitch.service.YilouService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/8/14.
 */
public class YilouMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        context.start();
        YilouService yilouService = (YilouService) context.getBean("yilouService");
        System.out.println(yilouService.getYilouList());
    }
}

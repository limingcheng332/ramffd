package com.mitch.dubbo;

import com.mitch.bean.Test;
import com.mitch.redis.RedisUtil;
import com.mitch.service.YilouService;
import com.mitch.utils.SpringContextUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/14.
 */
public class YilouMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        context.start();
//        YilouService yilouService = (YilouService) context.getBean("yilouService");
//        System.out.println(yilouService.getYilouList());
        RedisUtil redisUtil = SpringContextUtil.getBean(RedisUtil.class);
        Map map = new HashMap();
        map.put("aaaa","asas");
        map.put("bbbb","assssss");
////        System.out.println(redisUtil.set("json",map));
//        System.out.println("---------------------------"+redisUtil.get("json"));
//        System.out.println("---------------------------"+redisUtil.getClass().getDeclaredMethod("get",String.class).invoke(redisUtil,"json"));
        Test test = new Test();
        test.setMap(map);
        test.setStr("aaaaa");
        test.setClazz(RedisUtil.class);
//        System.out.println(redisUtil.set("test",test));
        System.out.println("---------------------------"+redisUtil.get("USER::00001"));
    }

}

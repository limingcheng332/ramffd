package com.mitch.helper;

import com.mitch.Util.ClassUtil;
import com.mitch.annotation.RamffdAPI;
import com.mitch.annotation.RamffdFunction;
import com.mitch.config.ServerConfigBean;
import com.mitch.mapper.APIMapper;
import com.mitch.netty.APIBootstrap;
import com.mitch.redis.RedisUtil;
import com.mitch.utils.SpringContextUtil;
import com.mitch.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * api接口发布
 * Created by limc on 2017/8/16.
 */
public class APIHelper {
    private static Logger logger = Logger.getLogger(APIHelper.class);
    private static RedisUtil redisUtil = SpringContextUtil.getBean("redisUtil");

    private  static String basepackage;

    private static Set<Class<?>> classSet = new HashSet<Class<?>>();

    public static void init(){
        String base = ServerConfigBean.getConfigBean().getApiBasepackage();
        basepackage = StringUtil.isEmpty(base) ? "com.mitch": base;
        classSet = ClassUtil.getClassSet(basepackage);
        saveAPI2Cache(classSet);
    }

    private static void saveAPI2Cache(Set<Class<?>> classSet) {
        //筛选api注解的class
        Set<Class<?>> apiClassSet = getAPIClassSet(classSet);
        for(Class<?> clz : apiClassSet){
            RamffdAPI ramffdAPI  = clz.getAnnotation(RamffdAPI.class);
            String modelName = ramffdAPI.value();
            Assert.hasLength(modelName,String.format("Class [%s] 的类注解异常",clz));

            Method[] methods = clz.getMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(RamffdFunction.class)){
                    RamffdFunction ramffdFunction = method.getAnnotation(RamffdFunction.class);
                    String functionno = ramffdFunction.value();
                    String functionExplain = ramffdFunction.explain();
                    Assert.hasLength(functionno,String.format("Class [%s] 的方法[%s]注解异常",clz,method));

                    APIMapper apiMapper = new APIMapper();
                    apiMapper.setClazz(clz);
//                    apiMapper.setMethod(method);
                    apiMapper.setApiName(modelName);
                    apiMapper.setFunctionNo(functionno);
                    apiMapper.setExplain(functionExplain);
                    redisUtil.set(apiMapper.getPath(apiMapper.getApiName(),apiMapper.getFunctionNo()),apiMapper);
                    logger.info(String.format("--------------api接口:[%s],模块:[%s],功能号:[%s]已经放入缓存-------------",apiMapper.getExplain(),apiMapper.getApiName(),apiMapper.getFunctionNo()));
                }
            }
        }
    }

    private static Set<Class<?> > getAPIClassSet(Set<Class<?> > classSet){
        Set<Class<?>> apiClassSet = new HashSet<Class<?>>();
        for(Class<?> cls : classSet){
            if(cls.isAnnotationPresent(RamffdAPI.class)){
                apiClassSet.add(cls);
            }
        }
        return apiClassSet;
    }
}

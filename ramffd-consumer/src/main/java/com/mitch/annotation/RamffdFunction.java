package com.mitch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * api中的功能号
 * Created by limc on 2017/8/16.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RamffdFunction {
    //根据功能号映射执行接口
    String value();
    String explain();
}

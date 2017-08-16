package com.mitch.bean;

import com.mitch.apis.UserAPI;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
public class Test implements Serializable{
    private Map map;
    private String str;
    private Class clazz;

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Test{");
        sb.append("map=").append(map);
        sb.append(", str='").append(str).append('\'');
        sb.append(", clazz=").append(clazz);
        sb.append('}');
        return sb.toString();
    }
}

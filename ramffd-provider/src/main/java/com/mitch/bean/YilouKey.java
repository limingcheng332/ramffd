package com.mitch.bean;

import java.io.Serializable;

public class YilouKey implements Serializable{
    private String countDatetime;

    private Integer playCode;

    private Integer chartType;

    public String getCountDatetime() {
        return countDatetime;
    }

    public void setCountDatetime(String countDatetime) {
        this.countDatetime = countDatetime == null ? null : countDatetime.trim();
    }

    public Integer getPlayCode() {
        return playCode;
    }

    public void setPlayCode(Integer playCode) {
        this.playCode = playCode;
    }

    public Integer getChartType() {
        return chartType;
    }

    public void setChartType(Integer chartType) {
        this.chartType = chartType;
    }
}
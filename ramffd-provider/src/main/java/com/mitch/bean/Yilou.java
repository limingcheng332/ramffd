package com.mitch.bean;

import java.io.Serializable;

public class Yilou extends YilouKey implements Serializable{
    private String playEname;

    private String termCode;

    private String maxVal;

    private String curVal;

    private String timesVal;

    public String getPlayEname() {
        return playEname;
    }

    public void setPlayEname(String playEname) {
        this.playEname = playEname == null ? null : playEname.trim();
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode == null ? null : termCode.trim();
    }

    public String getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(String maxVal) {
        this.maxVal = maxVal == null ? null : maxVal.trim();
    }

    public String getCurVal() {
        return curVal;
    }

    public void setCurVal(String curVal) {
        this.curVal = curVal == null ? null : curVal.trim();
    }

    public String getTimesVal() {
        return timesVal;
    }

    public void setTimesVal(String timesVal) {
        this.timesVal = timesVal == null ? null : timesVal.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Yilou{");
        sb.append("playEname='").append(playEname).append('\'');
        sb.append(", termCode='").append(termCode).append('\'');
        sb.append(", maxVal='").append(maxVal).append('\'');
        sb.append(", curVal='").append(curVal).append('\'');
        sb.append(", timesVal='").append(timesVal).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
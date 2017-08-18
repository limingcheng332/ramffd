package com.mitch.netty.massage;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/18.
 */
public class Response extends Message implements Serializable {
    private String errcode;
    private String errmsg;
    private String massage;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}

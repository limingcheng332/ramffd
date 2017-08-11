package com.mitch.exception;

import javax.management.relation.RoleUnresolved;

/**
 * Created by Administrator on 2017/8/11.
 */
public class LoginException extends RuntimeException{
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码
     */
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public LoginException(String code, String msg) {
        super(msg);
        this.code = code;
    }
    /**
     * 将异常封装为BusinessException，并指定错误码和默认提示
     *
     * @param code 错误码
     * @param message 默认错误信息
     * @param t 源异常
     */
    public LoginException(String code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }
}

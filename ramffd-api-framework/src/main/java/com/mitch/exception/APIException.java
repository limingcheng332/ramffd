package com.mitch.exception;

/**
 * Created by limc on 2017/8/18.
 */
public class APIException extends RuntimeException {
    /**
     * 错误码
     */
    private String code;


    public String getCode() {
        return code;
    }


    public APIException(String code, String msg) {
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
    public APIException(String code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }
}

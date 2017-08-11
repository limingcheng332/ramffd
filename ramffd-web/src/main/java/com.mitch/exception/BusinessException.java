package com.mitch.exception;

/**
 * Created by limc on 2017/8/11.
 */
public class BusinessException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = -6622516478244493096L;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码
     */
    private String webErrorCode;

    /**
     * 错误信息
     */
    private String webErrorMessage;


    public String getCode() {
        return code;
    }

    public String getWebErrorCode() {
        return webErrorCode;
    }

    public String getWebErrorMessage() {
        return webErrorMessage;
    }

    /**
     * 使用错误码、默认提示定义BusinessException
     *
     * @param code 错误码
     * @param message 默认错误信息
     */
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 将异常封装为BusinessException，并指定错误码和默认提示
     *
     * @param code 错误码
     * @param message 默认错误信息
     * @param t 源异常
     */
    public BusinessException(String code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }


    /**
     * 将异常封装为BusinessException，并指定错误码和默认提示
     *
     * @param code 错误码
     * @param message 默认错误信息
     * @param webErrorCode 通讯错误码
     * @param webErrorMessage 通讯错误信息
     */
    public BusinessException(String code, String message, String webErrorCode, String webErrorMessage) {
        super(message);
        this.code = code;
        this.webErrorCode = webErrorCode;
        this.webErrorMessage = webErrorMessage;
    }

    /**
     * 将异常封装为BusinessException，并指定错误码和默认提示
     *
     * @param code 错误码
     * @param message 默认错误信息
     * @param webErrorCode 通讯错误码
     * @param webErrorMessage 通讯错误信息
     * @param t 源异常
     */
    public BusinessException(String code, String message, String webErrorCode, String webErrorMessage, Throwable t) {
        super(message, t);
        this.code = code;
        this.webErrorCode = webErrorCode;
        this.webErrorMessage = webErrorMessage;
    }
}

package com.mitch.controller;

import com.mitch.exception.BusinessException;
import com.mitch.exception.LoginException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;


/**
 * 统一异常处理
 * Created by limc on 2017/8/11.
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = Logger.getLogger(ControllerExceptionHandler.class);

    /**
     * 处理业务异常
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = {BusinessException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handBusinnessException(BusinessException exception, WebRequest request) {
        logger.error("全局捕获一个异常：\n", exception);
        request.setAttribute("errMsg",exception.getCode()+"："+exception.getMessage(), RequestAttributes.SCOPE_REQUEST);
        return  new ModelAndView("public/error");
    }

    /**
     * 处理登录异常
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = {LoginException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handLoginException(LoginException exception, WebRequest request) {
        logger.info("Catch an exception", exception);
        request.setAttribute("code",exception.getCode(), RequestAttributes.SCOPE_REQUEST);
        request.setAttribute("msg",exception.getMsg(), RequestAttributes.SCOPE_REQUEST);
        return  new ModelAndView("user/login");
    }

    /**
     * 处理映射异常
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView noMapping(Exception exception, WebRequest request) {
        logger.info("No mapping exception", exception);
        return  new ModelAndView("public/404");
    }
}

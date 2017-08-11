package com.mitch.controller;

import com.mitch.bean.Yilou;
import com.mitch.exception.BusinessException;
import com.mitch.service.YilouService;
import com.mitch.utils.SpringContextUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by limc on 2017/8/10.
 */
@Controller
@RequestMapping("/yilou")
public class YilouController {
    Logger logger = Logger.getLogger(YilouController.class);
    @Resource
    private YilouService yilouService;
    @RequestMapping("/list")
    public List<Yilou> list(HttpServletRequest req){
        logger.info("此时的SPring上下文中的对象:"+ SpringContextUtil.getBean("controllerExceptionHandler"));
        if(req.getParameter("error") != null){
            throw new BusinessException("0001","模拟错误");
        }
        List<Yilou> yilous = yilouService.getYilouList();
        req.setAttribute("yilous",yilous);
        return yilous;
    }
}

package com.mitch.service.impl;

import com.mitch.bean.Yilou;
import com.mitch.dao.YilouMapper;
import com.mitch.service.YilouService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
@Service("yilouService")
public class YilouServiceImpl implements YilouService,Serializable{
    Logger logger = Logger.getLogger(YilouServiceImpl.class);
    @Resource
    private YilouMapper yilouMapper;


    public List<Yilou> getYilouList() {
        List<Yilou> yilous = this.yilouMapper.list();
        logger.info(String.format("返回的结果集为[%s]",yilous));
        return yilous;
    }
}

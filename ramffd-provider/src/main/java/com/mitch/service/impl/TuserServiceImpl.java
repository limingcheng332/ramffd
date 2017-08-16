package com.mitch.service.impl;

import com.mitch.bean.Tuser;
import com.mitch.dao.TuserMapper;
import com.mitch.service.TuserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service("tuserService")
public class TuserServiceImpl implements TuserService {
    Logger logger = Logger.getLogger(TuserServiceImpl.class);
    @Resource
    private TuserMapper tuserMapper;

    /**
     * 根据条件查找用户
     * @param tuser
     * @return
     */
    public Tuser getUser(Tuser tuser) {
        logger.info(String.format("查找用户传入条件[%s]",tuser));
        Tuser user = tuserMapper.getUser(tuser);
        logger.info(String.format("查出用户[%s]",user));
        return user;
    }
}

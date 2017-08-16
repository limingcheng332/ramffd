package com.mitch.dao;

import com.mitch.bean.Tuser;
import org.springframework.stereotype.Repository;

@Repository
public interface TuserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    Tuser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
    Tuser getUser(Tuser tuser);
}
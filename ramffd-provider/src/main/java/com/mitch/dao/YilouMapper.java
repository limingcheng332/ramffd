package com.mitch.dao;

import com.mitch.bean.Yilou;
import com.mitch.bean.YilouKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YilouMapper {
    int deleteByPrimaryKey(YilouKey key);

    int insert(Yilou record);

    int insertSelective(Yilou record);

    Yilou selectByPrimaryKey(YilouKey key);

    int updateByPrimaryKeySelective(Yilou record);

    int updateByPrimaryKey(Yilou record);
    List<Yilou> list();
}
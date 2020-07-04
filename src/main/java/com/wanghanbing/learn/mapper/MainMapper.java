package com.wanghanbing.learn.mapper;

import com.wanghanbing.learn.dao.bo.MainBo;
import com.wanghanbing.learn.po.Main;

public interface MainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Main record);

    int insertSelective(Main record);

    Main selectByPrimaryKey(Integer id);

    int updateStatusByName(MainBo main);

    int updateByPrimaryKey(Main record);
}
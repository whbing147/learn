package com.wanghanbing.learn.mapper;

import com.wanghanbing.learn.po.Detail;

public interface DetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Detail record);

    int insertSelective(Detail record);

    Detail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKey(Detail record);
}
package com.wanghanbing.learn.mapper;

import com.wanghanbing.learn.dao.bo.MainBo;
import com.wanghanbing.learn.po.Detail;

public interface DetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Detail record);

    int insertSelective(Detail record);

    Detail selectByName(String name);

    int updateStatusByName(MainBo mainBo);

    int updateByPrimaryKey(Detail record);
}
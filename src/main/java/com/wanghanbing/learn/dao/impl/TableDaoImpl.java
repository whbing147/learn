package com.wanghanbing.learn.dao.impl;

import com.wanghanbing.learn.dao.ITableDao;
import com.wanghanbing.learn.dao.bo.MainBo;
import com.wanghanbing.learn.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableDaoImpl implements ITableDao {

    @Autowired
    private MainMapper mainMapper;

    @Override
    public int updateStatusByName(String name, String oldStatus, String newStatus) {
        MainBo main = new MainBo();
        main.setName(name);
        main.setOldStatus(oldStatus);
        main.setNewStatus(newStatus);
        return mainMapper.updateStatusByName(main);
    }
}
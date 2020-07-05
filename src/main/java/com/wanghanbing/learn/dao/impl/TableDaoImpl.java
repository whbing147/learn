package com.wanghanbing.learn.dao.impl;

import com.wanghanbing.learn.dao.ITableDao;
import com.wanghanbing.learn.dao.bo.MainBo;
import com.wanghanbing.learn.mapper.DetailMapper;
import com.wanghanbing.learn.mapper.MainMapper;
import com.wanghanbing.learn.po.Detail;
import com.wanghanbing.learn.po.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TableDaoImpl implements ITableDao {

    @Autowired
    private MainMapper mainMapper;

    @Autowired
    private DetailMapper detailMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateMainStatusByName(String name, String oldStatus, String newStatus) {
        MainBo main = new MainBo();
        main.setName(name);
        main.setOldStatus(oldStatus);
        main.setNewStatus(newStatus);
        int i = mainMapper.updateStatusByName(main);
        int j = detailMapper.updateStatusByName(main);
        if (i * j == 0) {
            System.out.println("Unknown Exception = i=" + i + ",j=" + j);
        } else {
            System.out.println("----------更新成功-------------");
        }
        return i * j;
    }

    @Override
    public Main selectMainByName(String name) {
        return mainMapper.selectByName(name);
    }

    @Override
    public Detail selectDetailByName(String name) {
        return detailMapper.selectByName(name);
    }

}
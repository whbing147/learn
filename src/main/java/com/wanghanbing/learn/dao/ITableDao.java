package com.wanghanbing.learn.dao;


import com.wanghanbing.learn.po.Detail;
import com.wanghanbing.learn.po.Main;

public interface ITableDao {

    int updateMainStatusByName(String name, String oldStatus, String newStatus);

    Main selectMainByName(String name);

    Detail selectDetailByName(String name);
}

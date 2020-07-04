package com.wanghanbing.learn.dao;


public interface ITableDao {

    int updateStatusByName(String name, String oldStatus, String newStatus);
}

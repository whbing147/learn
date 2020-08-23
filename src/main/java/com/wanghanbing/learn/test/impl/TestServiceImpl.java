package com.wanghanbing.learn.test.impl;

import com.wanghanbing.learn.test.ITestService;

public class TestServiceImpl implements ITestService {


    @Override
    public String printHelloWord() {
        System.out.println("Hello word");
        return "hehe";
    }
}
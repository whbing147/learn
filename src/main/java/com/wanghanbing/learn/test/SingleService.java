package com.wanghanbing.learn.test;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class SingleService {

    private int count = 0;

    public void methodA(int threadName) throws InterruptedException {
        int sleep = new Random().nextInt(5);
        System.out.println("进程：" + threadName +",methodA"+ "   开始进入休眠=" + sleep+ "，时间" + new Date().toString());
        Thread.sleep(sleep * 1000L);
        System.out.println("进程：" + threadName + ",methodA=" + count++ + "，时间" + new Date().toString());

    }

    public void methodB(int threadName) throws InterruptedException {
        int sleep = new Random().nextInt(5);
        System.out.println("进程：" + threadName +",methodB" + "   开始进入休眠=" + sleep + "，时间" + new Date().toString());
        Thread.sleep(sleep * 1000L);
        System.out.println("进程：" + threadName + ",methodB=" + count++ + "，时间" + new Date().toString());
    }

    public void method(int threadName) throws InterruptedException {
        System.out.println("------------线程:" + threadName + "-----------");
        methodA(threadName);
        methodB(threadName);
    }
}
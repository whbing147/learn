package com.wanghanbing.learn;

import com.wanghanbing.learn.test.SingleService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleServiceTest extends SpringBaseServiceTest {

    @Resource
    private SingleService singleService;

    @Test
    public void multiMethodRun() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int threadCount = 10;
        int millSecond = 10;
        for (int i = 1; i <= threadCount; i++) {
            Thread.sleep(1000L);
            final int x = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("进入线程：" + x);
                    try {
                        Thread.sleep((millSecond - x) * 1000L);
                        int selectMethod = new Random().nextInt(2);
                        if (selectMethod == 0) {
                            singleService.methodA(x);
                        } else {
                            singleService.methodB(x);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        Thread.sleep(100000L);
    }

    @Test
    public void multiMethodRun1() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int threadCount = 10;
        int millSecond = 10;
        for (int i = 1; i <= threadCount; i++) {
            Thread.sleep(1000L);
            final int x = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("进入线程：" + x);
                    try {
                        Thread.sleep((millSecond - x) * 1000L);
                        singleService.method(x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        Thread.sleep(100000L);
    }
}
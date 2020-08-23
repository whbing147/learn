package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test12 extends SpringBaseServiceTest {

    private  final Logger logger = LoggerFactory.getLogger(Test12.class);

    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    @Resource
    private ITestService testService;

    private static int count = 0;


    @Test
    public void test1() {

        for (int i = 0; i < 3; i++) {
            Task worker = new Task();
            // 周期性执行，每5秒执行一次
            scheduledThreadPool.scheduleAtFixedRate(worker, 0,5, TimeUnit.SECONDS);
        }
    }



    @Test
    public void test2() throws InterruptedException {
        //Mockito.when(testService.printHelloWord()).thenReturn("Hello word");
        for (int i = 0; i < 100; i++) {
            Mockito.when(testService.printHelloWord()).thenReturn("Hello word");
            int random = new Random().nextInt(3000);
            Thread.sleep(random);
            logger.info("--------Test1--------, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        }



    }


    private class Task implements Runnable{

        @Override
        public void run() {
            Mockito.when(testService.printHelloWord()).thenReturn("Hello word" + count++);
            System.out.println("定时任务：" + testService.printHelloWord());
        }
    }
}
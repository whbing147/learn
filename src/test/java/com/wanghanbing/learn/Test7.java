package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class Test7 extends SpringBaseServiceTest {

    private  final Logger logger = LoggerFactory.getLogger(Test7.class);

    @Resource
    private ITestService testService;

    private static int count = 0;


    @Test
    public void wangh() throws InterruptedException {
        //Mockito.when(testService.printHelloWord()).thenReturn("xinyue111");
        logger.info("--------Test7---1-----, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test7-1---" + testService.printHelloWord()  + ",hashCode" + testService.hashCode());
    }

    @Test
    public void whan() throws InterruptedException {
        //Mockito.when(testService.printHelloWord()).thenReturn("xinyue");
        logger.info("--------Test7--------, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test7----" + testService.printHelloWord()  + ",hashCode" + testService.hashCode());

    }


    @Test
    public void whan1() throws InterruptedException {
        //Mockito.when(testService.printHelloWord()).thenReturn("xinyue");
        logger.info("--------Test7--------, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test7----" + testService.printHelloWord()  + ",hashCode" + testService.hashCode());

    }




}
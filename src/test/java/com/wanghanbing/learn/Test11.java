package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class Test11 extends SpringBaseServiceTest {

    private  final Logger logger = LoggerFactory.getLogger(Test11.class);

    @Resource
    private ITestService testService;

    @Test
    public void whan() {
        Mockito.when(testService.printHelloWord()).thenReturn("xinyue1");
        logger.info("--------Test6-----1---, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test6--2--" + testService.printHelloWord()  + ",hashCode" + testService.hashCode());
        Mockito.verify(testService, Mockito.times(2)).printHelloWord();
    }

    @Test
    public void wang() {
        Mockito.when(testService.printHelloWord()).thenReturn("xinyue2");
        logger.info("--------Test6------3--, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test6--4--" + testService.printHelloWord()  + ",hashCode" + testService.hashCode());
        Mockito.verify(testService, Mockito.times(2)).printHelloWord();
    }
}
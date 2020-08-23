package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class Test8 extends SpringBaseServiceTest {

    private  final Logger logger = LoggerFactory.getLogger(Test8.class);

    @Resource
    private ITestService testService;

    @Test
    public void test33333333() {
        //Mockito.when(testService.printHelloWord()).thenReturn("xinyue");
        logger.info("--------Test8--------, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test8----" + testService.printHelloWord()  + ",hashCode" + testService.hashCode());
    }
}
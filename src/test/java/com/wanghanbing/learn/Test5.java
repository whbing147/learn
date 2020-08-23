package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class Test5 extends SpringBaseServiceTest {

    private  final Logger logger = LoggerFactory.getLogger(Test5.class);

    @Resource
    private ITestService testService;

    @Test
    public void test33333333() {
        //Mockito.when(testService.printHelloWord()).thenReturn("minbgming");
        logger.info("--------Test5--------, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test5----" + testService.printHelloWord() + ",hashCode" + testService.hashCode());
    }
}
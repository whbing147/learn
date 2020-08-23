package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Resource;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

public class Test2 extends SpringBaseServiceTest {
    private  final Logger logger = LoggerFactory.getLogger(Test2.class);

    @Resource
    private ITestService testService;

    @Test
    public void test33333333() {
        //Mockito.when(testService.printHelloWord()).thenReturn("bingbing");
        logger.info("--------Test2--------, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test2-----" + testService.printHelloWord() + ",hashCode" + testService.hashCode());
    }

}
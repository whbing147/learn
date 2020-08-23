package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class Test1 extends SpringBaseServiceTest {

    private  final Logger logger = LoggerFactory.getLogger(Test1.class);

    @Resource
    private ITestService testService;

    @Before
    public void hh() {
        System.out.println("Test1   before");
    }


    @Test
    public void test1() {
        //Mockito.when(testService.printHelloWord()).thenReturn("Hello word");
        logger.info("--------Test1--------, {}, hashCode:{}", testService.printHelloWord() , testService.hashCode());
        System.out.println("--------Test1--------" + testService.printHelloWord() + ",hashCode" + testService.hashCode());
    }
}
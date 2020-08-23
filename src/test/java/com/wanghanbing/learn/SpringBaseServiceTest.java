package com.wanghanbing.learn;


import com.wanghanbing.learn.test.ITestService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml" })
public class SpringBaseServiceTest {

    @Resource
    private ITestService testService;

    @Before
    public void initBefore() {
        System.out.println("SpringBaseServiceTest before");
    }

    @After
    public void init() {
        Mockito.reset(testService);
        System.out.println("----王寒冰----");
    }


    public void test1245() {
        System.out.println("--------SpringBaseServiceTest--------");
    }

}
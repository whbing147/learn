package com.wanghanbing.learn;

import com.wanghanbing.learn.test.ITestService;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Configuration
public class CreateBeanFactory {

    static ThreadLocal<ITestService> threadLocal = new ThreadLocal<>();

    static Set<Integer> hashcode = new HashSet<>();
    static int count = 0;

    private  final Logger logger = LoggerFactory.getLogger(CreateBeanFactory.class);


    @Bean
    //@Scope("prototype")
    public ITestService createTestService() {
        /*if (threadLocal.get() == null) {
            ITestService newTestService = Mockito.mock(ITestService.class);
            int count = 0;
            System.out.println("集合大小：" + hashcode.size());
            while (!hashcode.add(newTestService.hashCode())) {
                newTestService = Mockito.mock(ITestService.class);
                count++;
                System.out.println("循环次数" + count);
            }
            System.out.println("集合大小1：" + hashcode.size());

            logger.info("产生新的:" + newTestService.hashCode());
            System.out.println("产生新的:" + newTestService.hashCode());
            threadLocal.set(newTestService);
        } else {
            logger.info("已存在:" + threadLocal.get().hashCode());
            System.out.println("已存在::" + threadLocal.get().hashCode());
            ITestService newTestService = Mockito.mock(ITestService.class);
            int count = 0;
            System.out.println("集合大小222：" + hashcode.size());
            while (!hashcode.add(newTestService.hashCode())) {
                newTestService = Mockito.mock(ITestService.class);
                count++;
                System.out.println("循环次数" + count);
            }
            System.out.println("集合大小2223：" + hashcode.size());
            threadLocal.set(newTestService);
        }*/
        ITestService testService = Mockito.mock(ITestService.class);
        int random = new Random().nextInt(1000);
        /*if (random % 20 >=0 && random % 20 <= 10) {
            Mockito.when(testService.printHelloWord()).thenReturn("haha" + random % 20);
        }*/

        //ITestService testService = threadLocal.get();
        //System.out.println("threadLocal=" + threadLocal.toString());
        //System.out.println("线程：" + Tread.currentThread().getName()+ "----" + testService.hashCode());
        logger.info("线程：{}, hashcode:{}, {}, random:{}", Thread.currentThread().getName(), testService.hashCode(), testService, random % 20);
        return testService;
    }


    public static void main(String[] args) {
        ITestService testService = Mockito.mock(ITestService.class);
        System.out.println(testService);
        System.out.println(testService.hashCode());

    }
}
package com.wanghanbing.learn;

import com.wanghanbing.learn.dao.ITableDao;
import com.wanghanbing.learn.dao.bo.MainBo;
import com.wanghanbing.learn.po.Detail;
import com.wanghanbing.learn.po.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml" })
public class TransactionTest {

    @Autowired
    private ITableDao tableDao;

    @Test
    public void query() {
        Main main = tableDao.selectMainByName("wanghanbing");
        System.out.println(main);
    }

    @Test
    public void update() throws InterruptedException {
        String name = "wanghanbing";
        try {

            int ss = tableDao.updateMainStatusByName("wanghanbing", "02", "01");
            System.out.println(ss);
        } catch (Exception e) {
           e.printStackTrace();
        }

        Thread.sleep(3000L);

        Main main = tableDao.selectMainByName(name);
        Detail detail = tableDao.selectDetailByName(name);
        System.out.println("before->main status:" + main.getStatus() + ", detail status:" + detail.getStatus());

    }

    @Test
    public void multiUpdate() throws InterruptedException, ExecutionException {
        String name = "wanghanbing";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int runCount = 1;
        int loopCount = 10;
        for (int c = 0; c < loopCount; c++) {
            System.out.println("-------------运行到" + runCount++ + "次---------");
            String oldStatus = "01";
            String newStatus = "02";
            MainBo mainBo = new MainBo();
            mainBo.setName(name);
            mainBo.setOldStatus(oldStatus);
            mainBo.setNewStatus(newStatus);
            Main main = tableDao.selectMainByName(name);
            Detail detail = tableDao.selectDetailByName(name);
            if (main.getStatus().equals(newStatus) && detail.getStatus().equals(newStatus)) {
                int ss = tableDao.updateMainStatusByName(name, newStatus, oldStatus);
                System.out.println(ss);
            } else if (main.getStatus().equals(newStatus) || detail.getStatus().equals(newStatus)) {
                System.out.println("数据库状态不对，终止执行");
                break;
            }

            main = tableDao.selectMainByName(name);
            detail = tableDao.selectDetailByName(name);
            System.out.println("before->main status:" + main.getStatus() + ", detail status:" + detail.getStatus());

            int threadCount = new Random().nextInt(8) + 2;
            int fail = 0;

            List<Future<Integer>> featureList = new ArrayList<>();
            for (int i = 1; i <= threadCount; i++) {
                Thread.sleep(1000L);
                UpdateCallable updateCallable = new UpdateCallable(threadCount, i, tableDao, mainBo);
                Future<Integer> feature = executorService.submit(updateCallable);
                featureList.add(feature);
            }
            for (Future<Integer> result: featureList) {
                if (result.get() == 0) {
                    fail++;
                }
            }

            System.out.println("失败次数：" + fail);

            if (fail == threadCount) {
                System.out.println("---------终于找到了--------");
                break;
            }

            Thread.sleep(1000L);
            main = tableDao.selectMainByName(name);
            detail = tableDao.selectDetailByName(name);
            System.out.println("after->main status:" + main.getStatus() + ", detail status:" + detail.getStatus());
        }


        Main main = tableDao.selectMainByName(name);
        Detail detail = tableDao.selectDetailByName(name);
        System.out.println("laster->main status:" + main.getStatus() + ", detail status:" + detail.getStatus());


    }

    private class UpdateCallable implements Callable<Integer> {
        private int threadCount;
        private int threadName;
        private ITableDao tableDao;
        private MainBo main;

        public UpdateCallable(int threadCount, int threadName, ITableDao tableDao, MainBo main) {
            this.threadCount = threadCount;
            this.tableDao = tableDao;
            this.main = main;
            this.threadName = threadName;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("进入进程：" + threadName);
            Thread.sleep((threadCount-threadName) * 1000L);
            int result = tableDao.updateMainStatusByName(main.getName(), main.getOldStatus(), main.getNewStatus());
            if (result != 0) {
                System.out.println("进程：" + threadName + "，执行成功");
            } else {
                System.out.println("进程：" + threadName + "，更新失败");
            }
            return result;
        }
    }


}
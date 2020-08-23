package com.wanghanbing.learn;

import com.alibaba.fastjson.JSON;
import com.wanghanbing.learn.dao.ITableDao;
import com.wanghanbing.learn.dao.bo.MainBo;
import org.junit.Test;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapTest {


    public void test() throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        UpdateCallable updateCallable = new UpdateCallable(2, 1, hashMap);
        RemoveCallable removeCallable = new RemoveCallable(2,2,hashMap);
        executorService.submit(updateCallable);
        Thread.sleep(1000L);
        executorService.submit(removeCallable);
        Thread.sleep(1000L);
    }


    public static void main(String[] args) {
        /** 全局HashMap*/
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();

        /** 多线程编辑100次*/
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i);
        }

        //new Thread(new AddThread(hashMap)).start();
        new Thread(new RemoveThread(hashMap)).start();

        /** 读取线程*/
        new Thread(new IteratorThread(hashMap)).start();
        /** 输出最终结果*/
    }

    private class UpdateCallable implements Callable<Integer> {
        private int threadCount;
        private int threadName;
        private ConcurrentHashMap<Integer, Integer> hashMap;

        public UpdateCallable(int threadCount, int threadName, ConcurrentHashMap<Integer, Integer> hashMap) {
            this.threadCount = threadCount;
            this.hashMap = hashMap;
            this.threadName = threadName;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("进入设置进程：" + threadName + new Date());
            Thread.sleep((threadCount-threadName) * 994L);
            System.out.println("开始设置进程：" + threadName + new Date());
            hashMap.put(1, 1);
            System.out.println(JSON.toJSONString("设置完读取结果：" + hashMap.get(1)) + new Date());
            return 1;
        }
    }
    private class RemoveCallable implements Callable<Integer> {
        private int threadCount;
        private int threadName;
        private ConcurrentHashMap<Integer, Integer> hashMap;

        public RemoveCallable(int threadCount, int threadName, ConcurrentHashMap<Integer, Integer> hashMap) {
            this.threadCount = threadCount;
            this.hashMap = hashMap;
            this.threadName = threadName;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("进入删除进程：" + threadName + new Date());
            Thread.sleep((threadCount-threadName) * 1000L);
            System.out.println("开始删除进程：" + threadName + new Date());
            System.out.println(JSON.toJSONString("删除结果：" + hashMap.remove(1)) + new Date());
            return 1;
        }
    }


}



class AddThread implements Runnable {
    Map<Integer, Integer> hashMap;

    public AddThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        int i = 0;
        while (i++ < 10) {
            int random = new Random().nextInt();
            hashMap.put(random, random);
        }
    }
}

class RemoveThread implements Runnable {
    Map<Integer, Integer> hashMap;

    public RemoveThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        int random = new Random().nextInt(1000);
        int i = 0;
        int count = i;
        while (i++ < 10) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("删除：" + count);
            hashMap.remove(count++);
        }
    }
}


class IteratorThread implements Runnable {

    Map<Integer, Integer> hashMap;

    public IteratorThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        while (true) {
            if (hashMap.isEmpty()) {
                break;
            }
            System.out.println("------------------ " + hashMap.size());
            try {
                String sb = "";
                for (Integer value : hashMap.keySet()) {
                    Thread.sleep(1000L);
                    System.out.println("获取：" + value + "，结果：" + hashMap.get(value) +",集合大小：" + hashMap.size() + ",[]=" + JSON.toJSONString(hashMap));
                    sb += "," + hashMap.get(value);
                }
                System.out.println(sb);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(JSON.toJSON(hashMap));
            System.out.println("+++++++++++++++++++ " + hashMap.size());
        }

    }

}
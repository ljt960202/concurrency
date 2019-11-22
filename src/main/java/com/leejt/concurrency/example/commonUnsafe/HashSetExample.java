package com.leejt.concurrency.example.commonUnsafe;

import com.leejt.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName StringExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/11/18 15:48
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class HashSetExample {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static Set<Integer> set = new HashSet<Integer>();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        log.info("size:{}",set.size());
        countDownLatch.await();
        executorService.shutdown();
    }
    private static void update(int count){
        set.add(count);
    }
}

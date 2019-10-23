package com.leejt.concurrency.example.count;

import com.leejt.concurrency.annoations.NotThreadSafe;
import com.leejt.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName ConcurrencyExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/17 16:25
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class CountExample4 {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static volatile int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }
    private  static void add(){
        count++;
        /**
         * 1.主内存中读取count值
         * 2.count+1
         * 3.写入主内存
         * 两个进程同时读取到最新的count值，都加了1，然后写入主内存的时候少了一个加1
         */
    }
}

package com.leejt.concurrency.example.commonUnsafe;

import com.leejt.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class DateFormatExample {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDD");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
    private static void update(){
        try {
            simpleDateFormat.parse("20191118");
        } catch (ParseException e) {
            log.error("exception:{}",e);
        }
    }
}

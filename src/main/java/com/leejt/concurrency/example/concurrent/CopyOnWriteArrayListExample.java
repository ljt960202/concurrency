package com.leejt.concurrency.example.concurrent;

import com.leejt.concurrency.annoations.NotThreadSafe;
import com.leejt.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName CopyOnWriteArrayList
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/9 11:25
 * @Version 1.0
 **/
@Slf4j
@ThreadSafe
public class CopyOnWriteArrayListExample {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static List<Integer> arrayList = new CopyOnWriteArrayList<>();
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
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",arrayList.size());
    }
    private static void update(int count){
        arrayList.add(count);
    }
}

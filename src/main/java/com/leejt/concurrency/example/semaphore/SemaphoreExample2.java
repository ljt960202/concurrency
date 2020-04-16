package com.leejt.concurrency.example.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/13 9:59
 * @Version 1.0
 **/
@Slf4j
public class SemaphoreExample2 {
    final private static int threadTotal = 20;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadTotal; i++) {
            final int threadNum =i;
            executorService.execute(()->{
                try {
                    semaphore.acquire(3);//获取多个信号量
                    test(threadNum);
                    semaphore.release(3);//释放多个信号量
                } catch (Exception e) {
                    log.info("Exception",e);
                }
            });
        }
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{}",threadNum);
    }

}

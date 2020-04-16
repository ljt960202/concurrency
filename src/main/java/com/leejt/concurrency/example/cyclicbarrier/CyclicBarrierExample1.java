package com.leejt.concurrency.example.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @ClassName CyclicBarrierExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/13 10:49
 * @Version 1.0
 **/
@Slf4j
public class CyclicBarrierExample1 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(()->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.info("Exception",e);
                }
            });
        }
    }
    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready"+threadNum);
        barrier.await();
        log.info("{} continue"+threadNum);
    }
}

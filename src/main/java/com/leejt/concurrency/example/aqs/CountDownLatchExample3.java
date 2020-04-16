package com.leejt.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountDownLatchExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/10 16:10
 * @Version 1.0
 **/
@Slf4j
public class CountDownLatchExample3 {

    final private static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> respLists = Collections.synchronizedList(new ArrayList<Integer>());
        final CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for (int i = 0; i < threadTotal; i++) {
            final int threadNum =i;
            executorService.execute(()->{
                try {
                    Thread.sleep(10000);
                    test(threadNum);
                    respLists.add(threadNum);
                } catch (Exception e) {
                    log.info("Exception",e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        //Thread.sleep(100);
        log.info("{}",threadNum);
        //Thread.sleep(100);
    }

}

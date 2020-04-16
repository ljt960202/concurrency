package com.leejt.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @ClassName FutrueExample
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/15 9:57
 * @Version 1.0
 **/
@Slf4j
public class FutrueTaskExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "done";
            }
        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result: {} ",result);
    }
}

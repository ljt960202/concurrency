package com.leejt.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName FutrueExample
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/15 9:57
 * @Version 1.0
 **/
@Slf4j
public class FutrueExample {
    static class MyCallable implements Callable<List<String>>{

        @Override
        public List<String> call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return new ArrayList<String>();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<String>> future = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        List<String> result = future.get();
        log.info("result: {} ",result);
        executorService.shutdown();
    }
}

package com.leejt.concurrency.example.sync;

import com.leejt.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SynchronizedExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/18 14:33
 * @Version 1.0
 **/
@ThreadSafe
@Slf4j
public class SynchronizedExample1 {

    //修饰代码块
    public void test1(int j){
        synchronized(this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 -{} - {}",j,i);
            }
        }
    }
    //修饰方法
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(()->{
            example1.test2(1);
        });
        executor.execute(()->{
            example2.test2(2);
        });
        executor.shutdown();
    }
}

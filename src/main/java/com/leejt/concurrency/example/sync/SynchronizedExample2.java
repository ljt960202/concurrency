package com.leejt.concurrency.example.sync;

import com.leejt.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

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
public class SynchronizedExample2 {

    //修饰类
    public static void test1(int j){
        synchronized(SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 -{} - {}",j,i);
            }
        }
    }
    //修饰静态方法
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(()->{
            example1.test1(1);
        });
        executor.execute(()->{
            example2.test1(2);
        });
        executor.shutdown();
    }
}

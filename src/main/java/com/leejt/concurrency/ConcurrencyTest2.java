package com.leejt.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ConcurrencyTest2
 * @Description 下面的代码并发执行一定比串行执行快吗
 * @Author Duplicator
 * @Date 2019/10/23 16:22
 * @Version 1.0
 **/
@Slf4j
public class ConcurrencyTest2 {
    private static final long count = 10000;
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a+=5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis()-start;
        log.info("concurrency:{}",time+"ms,b="+b);
    }

    public static void serial(){
        long start = System.currentTimeMillis();
        int a=0;
        for (int i = 0; i < count; i++) {
            a+=5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;
        log.info("serial:{}",time+"ms,b="+b+",a="+a);
    }

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
}

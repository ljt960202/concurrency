package com.leejt.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockExample6
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/14 11:01
 * @Version 1.0
 **/
@Slf4j
public class LockExample6 {

    public static void main(String[] args) {
        Lock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new Thread(()->{
            try {
                reentrantLock.lock();
                log.info("wait lock");
                condition.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            log.info("get signal");
            reentrantLock.unlock();
        }).start();
        new Thread(()->{
            reentrantLock.lock();
            log.info("get lock");
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal");
            reentrantLock.unlock();
        }).start();
    }
}

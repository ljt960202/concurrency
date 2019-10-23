package com.leejt.concurrency.example.atomic;

import com.leejt.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName ConcurrencyExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2019/10/17 16:25
 * @Version 1.0
 **/
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    public volatile int count=100;

    public static void main(String[] args) throws InterruptedException {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if(updater.compareAndSet(atomicExample5,100,120)){
            log.info("update success 1, {}",atomicExample5.getCount());
        }
        if(updater.compareAndSet(atomicExample5,100,120)){
            log.info("update success 2, {}",atomicExample5.getCount());
        }else{
            log.info("update failed, {}",atomicExample5.getCount());
        }
    }
}

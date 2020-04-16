package com.leejt.concurrency.example.synContainer;

import com.leejt.concurrency.annoations.NotThreadSafe;
import com.leejt.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName VectorExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/8 16:42
 * @Version 1.0
 **/
@NotThreadSafe
@Slf4j
public class VectorExample2 {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            Vector<Integer> vector = new Vector<>();
            for (int i=0;i<10;i++){
                vector.add(i);
            }
            Thread thread1 = new Thread(){
                public void run(){
                    for (int i=0;i<vector.size();i++){
                        vector.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread(){
                public void run(){
                    for (int i=0;i<vector.size();i++){
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}

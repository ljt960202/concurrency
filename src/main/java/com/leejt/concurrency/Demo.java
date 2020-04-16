package com.leejt.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/14 15:38
 * @Version 1.0
 **/
@Slf4j
public class Demo {
    public static void main(String[] args) throws InterruptedException {
/*        //总耗时
        System.out.println(20200414153201456L-20200414153132720L);
        //6
        System.out.println(20200414153155543L-20200414153132845L);
        //1
        System.out.println(20200414153156588L-20200414153132767L);
        //2
        System.out.println(20200414153157836L-20200414153134421L);
        //5
        System.out.println(20200414153158975L-20200414153133204L);
        //4
        System.out.println(20200414153200052L-20200414153133219L);
        //3
        System.out.println(20200414153201456L-20200414153133282L);*/
        log.info("程序开始时间： " + new Date());
        List<List<TestController>> lists = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(6);
        List<TestController> respLists = Collections.synchronizedList(new ArrayList<TestController>());
        for (int i=0;i<6;i++){
            final int ti=i;
            executorService.execute(()->{
                try {
                    log.info("{}",ti);
                    Thread.sleep(22222);
                    List<TestController> subRespList = new ArrayList<>();
                    TestController testController = new TestController();
                    subRespList.add(testController);
                    if(subRespList!=null&&subRespList.size()>0){
                        //把响应结果加到总的上去
                        respLists.addAll(subRespList);
                        log.info("end {}",ti);
                    }
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        executorService.shutdown();
        log.info("程序结束时间： " + new Date());
    }
}

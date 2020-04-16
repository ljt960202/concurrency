package com.leejt.concurrency.example.synContainer;

import com.leejt.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * @ClassName VectorExample1
 * @Description TODO
 * @Author Duplicator
 * @Date 2020/4/8 16:42
 * @Version 1.0
 **/
@NotThreadSafe
@Slf4j
public class VectorExample3 {

    //java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> vector){ //foreach
        for (Integer integer : vector) {
            if(integer.equals(3)){
                vector.remove(integer);
            }
        }
    }
    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> vector){//iterator
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(3)){
                vector.remove(i);
            }
        }
    }
    //successful
    private static void test3(Vector<Integer> vector){//for
        for (int i = 0; i < vector.size(); i++) {
            if(vector.get(i).equals(3)){
                vector.remove(vector.get(i));
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test2(vector);
    }
}

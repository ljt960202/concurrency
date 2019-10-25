package com.leejt.concurrency.example.singleton;

import com.leejt.concurrency.annoations.NotThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 懒汉模式-单例第一次使用的时候就创建实例
 * @Author Duplicator
 * @Date 2019/10/23 17:01
 * @Version 1.0
 **/
@NotThreadSafe
public class SingletonExample1 {
    //私有构造方法
    private SingletonExample1(){

    }
    //单例对象
    private static SingletonExample1 instance = null;
    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if (instance==null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}

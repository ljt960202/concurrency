package com.leejt.concurrency.example.singleton;

import com.leejt.concurrency.annoations.ThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 饿汉模式-单例实例在类装载的时候实现
 * @Author Duplicator
 * @Date 2019/10/23 17:01
 * @Version 1.0
 **/
@ThreadSafe
public class SingletonExample2 {
    //私有构造方法
    private SingletonExample2(){

    }
    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();
    //静态的工厂方法
    public SingletonExample2 getInstance(){
        return instance;
    }
}

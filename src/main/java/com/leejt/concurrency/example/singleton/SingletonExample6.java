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
//静态域和静态方法要有书写顺序
public class SingletonExample6 {
    //私有构造方法
    private SingletonExample6(){

    }
    //单例对象
    private static SingletonExample6 instance = null;
    static {
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}

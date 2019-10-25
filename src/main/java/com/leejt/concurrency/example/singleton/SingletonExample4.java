package com.leejt.concurrency.example.singleton;

import com.leejt.concurrency.annoations.NotThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 懒汉模式（双重同步锁单例模式）-单例第一次使用的时候就创建实例
 * @Author Duplicator
 * @Date 2019/10/23 17:01
 * @Version 1.0
 **/
@NotThreadSafe
public class SingletonExample4 {
    //私有构造方法
    private SingletonExample4(){

    }
    /**
     * 1.memory = allocate() 分配对象的内存空间
     * 2.ctorInstance() 初始化对象
     * 3.instance = memory 设置instance指向刚分配的内存
     */
    //JVM和CPU优化，发生了指令重排
    /**
     * 1.memory = allocate() 分配对象的内存空间
     * 3.instance = memory 设置instance指向刚分配的内存
     * 2.ctorInstance() 初始化对象
     */
    //单例对象
    private static SingletonExample4 instance = null;
    //静态的工厂方法
    public static SingletonExample4 getInstance(){
        if (instance==null){//双重检测机制
            synchronized (SingletonExample4.class){//同步锁
                if(instance==null){
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}

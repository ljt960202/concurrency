package com.leejt.concurrency.example.singleton;

import com.leejt.concurrency.annoations.NotRecommend;
import com.leejt.concurrency.annoations.NotThreadSafe;
import com.leejt.concurrency.annoations.ThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 懒汉模式-单例第一次使用的时候就创建实例
 * @Author Duplicator
 * @Date 2019/10/23 17:01
 * @Version 1.0
 **/
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    //私有构造方法
    private SingletonExample3(){

    }
    //单例对象
    private static SingletonExample3 instance = null;
    //静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if (instance==null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}

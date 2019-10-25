package com.leejt.concurrency.example.singleton;

import com.leejt.concurrency.annoations.NotThreadSafe;
import com.leejt.concurrency.annoations.Recommend;
import com.leejt.concurrency.annoations.ThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 枚举模式
 * @Author Duplicator
 * @Date 2019/10/23 17:01
 * @Version 1.0
 **/
@ThreadSafe
@Recommend
public class SingletonExample7 {
    //私有构造方法
    private SingletonExample7(){

    }
    //单例对象
    private static SingletonExample7 instance = null;
    //静态的工厂方法
    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }
        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}

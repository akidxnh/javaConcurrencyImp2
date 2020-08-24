package com.lwp.concurrency.example.singleton;

import com.lwp.concurrency.annoations.NotRecommend;
import com.lwp.concurrency.annoations.NotThreadSafe;
import com.lwp.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式，单例的实例，在第一次使用时创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有的构造对象
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance=null;

    //静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if (instance==null){
            instance= new SingletonExample3();
        }
        return instance;
    }
}

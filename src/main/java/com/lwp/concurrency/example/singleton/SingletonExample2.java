package com.lwp.concurrency.example.singleton;

import com.lwp.concurrency.annoations.NotThreadSafe;
import com.lwp.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式，单例的实例，在类加载使用时进行创建
 */
@ThreadSafe
public class SingletonExample2 {

    //私有的构造对象
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance=new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}

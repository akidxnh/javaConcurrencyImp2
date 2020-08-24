package com.lwp.concurrency.example.singleton;

import com.lwp.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式，单例的实例，在第一次使用时创建
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有的构造对象
    private SingletonExample1(){

    }

    //单例对象
    private static SingletonExample1 instance=null;

    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if (instance==null){
            instance= new SingletonExample1();
        }
        return instance;
    }
}

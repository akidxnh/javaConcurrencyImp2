package com.lwp.concurrency.example.singleton;

import com.lwp.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式，单例的实例，在类加载使用时进行创建
 */
@ThreadSafe
public class SingletonExample6 {

    //私有的构造对象
    private SingletonExample6(){

    }

    //注意顺序
    //单例对象
    private static SingletonExample6 instance=null;

    static {
        instance= new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}

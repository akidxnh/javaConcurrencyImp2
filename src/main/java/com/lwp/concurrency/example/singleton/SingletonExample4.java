package com.lwp.concurrency.example.singleton;

import com.lwp.concurrency.annoations.NotRecommend;
import com.lwp.concurrency.annoations.NotThreadSafe;
import com.lwp.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式，==》双重同步锁单例模式
 * 单例的实例，在第一次使用时创建
 *
 */
@NotThreadSafe
public class SingletonExample4 {

    //私有的构造对象
    private SingletonExample4(){

    }

    //单例对象
    private static SingletonExample4 instance=null;

    //1.memory = allocate() 分配对象内存空间
    //2.ctorInstance() 初始化对象
    //3.instance=memory 设置instance指向刚分配的内存

    //JVM和cpu优化，发生了指令重排序
    //1.memory = allocate() 分配对象内存空间
    //3.instance=memory 设置instance指向刚分配的内存
    //2.ctorInstance() 初始化对象

    //静态的工厂方法
    public static SingletonExample4 getInstance(){
        if (instance==null){//双重检测机制
            synchronized (SingletonExample4.class){//同步锁
                if (instance==null){
                    instance= new SingletonExample4();
                }
            }

        }
        return instance;
    }
}

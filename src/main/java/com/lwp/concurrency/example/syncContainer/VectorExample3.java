package com.lwp.concurrency.example.syncContainer;

import com.lwp.concurrency.annoations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;


public class VectorExample3 {

    //java.util.ConcurrentModificationException
    //如果要删除，最好遍历的时候先标记，遍历后再去删除
    private static void test1(Vector<Integer> vector){
        for(Integer i:vector){
            if (i.equals(3)){
                vector.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> vector){
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()){
            Integer i=iterator.next();
            if (i.equals(3)){
                vector.remove(i);
            }
        }


    }
    //不会抛出异常
    private static void test3(Vector<Integer> vector){
        for(int i=0;i<vector.size();i++){
            if (vector.get(i).equals(3)){
                vector.remove(i);
            }
        }
    }

    public static void main(String[] args) {

        Vector<Integer> vector= new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);

    }
}

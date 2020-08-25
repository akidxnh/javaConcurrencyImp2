package com.lwp.concurrency.example.immutable;

import java.util.Map;
import com.google.common.collect.Maps;
import com.lwp.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a= 1;
    private final static String  b="2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//        map=Maps.newHashMap();
        map.put(1,3);
        System.out.println(map);
    }

    private void test(final int a){
//        a=1;
    }

}

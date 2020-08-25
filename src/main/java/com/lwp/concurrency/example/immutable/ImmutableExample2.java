package com.lwp.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.lwp.concurrency.annoations.NotThreadSafe;
import com.lwp.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private final static Integer a= 1;
    private final static String  b="2";
    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map= Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,3);
        System.out.println(map);
    }

}

package com.lwp.concurrency.example.publish;

import com.lwp.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 使一个对象能够被当前范围之外的代码所使用
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states={"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish publish= new UnsafePublish();
        log.info("{}", Arrays.toString(publish.getStates()));
        publish.getStates()[0]="d";
        log.info("{}", Arrays.toString(publish.getStates()));
    }
}

package com.lwp.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {
    private static CyclicBarrier barrier= new CyclicBarrier(5);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            final int threadNum=i;
            Thread.sleep(1000);
            executorService.execute(()-> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception");
                }
            });
        }

        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        try {
            barrier.await(2, TimeUnit.SECONDS);
        }catch (BrokenBarrierException e){
            log.error("{} BrokenBarrierException",threadNum);
        }
        log.info("{} continue",threadNum);
    }
}

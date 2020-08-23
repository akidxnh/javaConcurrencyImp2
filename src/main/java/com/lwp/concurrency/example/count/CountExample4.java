package com.lwp.concurrency.example.count;

import com.lwp.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class CountExample4 {
    //请求总数
    public static int clientTotal=5000;
    //同时并发执行的线程
    public static int threadTotal=200;

    public static volatile int count=0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore= new Semaphore(threadTotal);
        final CountDownLatch countDownLatch= new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }

    private static void add(){
        count++;
        // 1.取count （count最新值可见）
        // 2。+1      多线程写回不具备原子性
        // 3。写会主存
    }
}

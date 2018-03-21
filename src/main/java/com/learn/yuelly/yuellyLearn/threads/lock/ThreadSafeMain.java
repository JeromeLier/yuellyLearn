package com.learn.yuelly.yuellyLearn.threads.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ll_yue on 2018/3/19.14:14
 */
@ThreadSafe
public class ThreadSafeMain {


    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadSafeMain.class);

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    @GuardedBy("this") private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public  synchronized void getLockInfo() {

        try {
            LOGGER.info("getLockInfo start... threadName={}", Thread.currentThread().getName());
            Thread.sleep(25000);

            LOGGER.info("getLockInfo end...threadName={}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.info("getLockInfo exception...threadName={}", Thread.currentThread().getName());
        }


    }

    public void testThread(){

        executorService.submit(new Runnable() {
            @Override public void run() {
                getLockInfo();
            }
        });
    }

    public static void main(String[] args) {


        ThreadSafeMain threadSafeMain = new ThreadSafeMain();

        threadSafeMain.testThread();




    }
}

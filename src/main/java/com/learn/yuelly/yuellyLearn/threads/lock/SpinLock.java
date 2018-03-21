package com.learn.yuelly.yuellyLearn.threads.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by ll_yue on 2018/3/21.10:54
 *  不可重入锁 实现
 */
public class SpinLock {

    private AtomicReference<Thread> owner =new AtomicReference<>();
    public void lock(){
        Thread current = Thread.currentThread();
        while(!owner.compareAndSet(null, current)){
        }
    }

    public void unlock (){
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }



    public static void main(String[] args) {





    }

}

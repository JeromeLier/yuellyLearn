package com.learn.yuelly.yuellyLearn.threads.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by ll_yue on 2018/3/21.10:54
 *  重入锁 实现
 */
public class UnSpinLock {

    private AtomicReference<Thread> owner =new AtomicReference<>();
    private AtomicInteger count = new AtomicInteger();
    public void lock(){
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            count.addAndGet(1);
        } else  {
            while(!owner.compareAndSet(null, current)){

            }
        }

    }

    public void unlock (){
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (count.decrementAndGet() == 0) {
                owner.compareAndSet(current, null);
            }
        }
        owner.compareAndSet(current, null);
    }



    public static void main(String[] args) {





    }

}

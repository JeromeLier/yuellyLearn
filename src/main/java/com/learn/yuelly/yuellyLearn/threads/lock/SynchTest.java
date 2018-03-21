package com.learn.yuelly.yuellyLearn.threads.lock;

/**
 * Created by ll_yue on 2018/3/21.11:00
 *
 * 验证 synchronized 是可以重入的
 */
public class SynchTest implements Runnable{

    public synchronized void get(){
        System.out.println(Thread.currentThread().getId());
        set();
    }
    public synchronized void set(){
        System.out.println(Thread.currentThread().getId());
    }
    @Override
    public void run() {
        get();
    }
    public static void main(String[] args) {
        SynchTest ss=new SynchTest();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }

}

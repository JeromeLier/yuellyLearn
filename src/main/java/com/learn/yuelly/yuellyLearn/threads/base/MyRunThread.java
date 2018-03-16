package com.learn.yuelly.yuellyLearn.threads.base;

/**
 * Created by ll_yue on 2018/3/16.14:39
 */
public class MyRunThread implements Runnable {

    public MyRunThread() {
    }

    @Override
    public void run() {
        System.out.println("子线程ID："+Thread.currentThread().getId());
    }

    public static void main(String[] args)  {
        System.out.println("主线程ID："+Thread.currentThread().getId());
        MyRunThread runnable = new MyRunThread();

        runnable.run();
        Thread thread = new Thread(runnable);
        thread.start();
    }

}

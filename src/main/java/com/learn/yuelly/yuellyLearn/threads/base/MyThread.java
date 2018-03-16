package com.learn.yuelly.yuellyLearn.threads.base;

/**
 * Created by ll_yue on 2018/3/16.14:24
 */
public class MyThread extends Thread {

    private static int num = 0;
    private static String staicName = null;

    public MyThread(){
        num++;
    }

    public MyThread(String name){
        staicName = name;
    }

    public void run() {
        System.out.println("name:"+staicName+" 子线程ID:"+Thread.currentThread().getId());
    }

    public static void main(String[] args)  {
        MyThread thread = new MyThread("线程");
        thread.start();

        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();

        

        System.out.println("主线程ID:"+Thread.currentThread().getId());
        System.out.println(thread.isAlive() + "");
        System.out.println(thread.isDaemon() + "");
        System.out.println(thread.isInterrupted() + "");


    }
}

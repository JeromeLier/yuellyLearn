package com.learn.yuelly.yuellyLearn.threads.lock;

/**
 * Created by ll_yue on 2018/3/21.11:00
 *
 * 验证 synchronized 范围
 *
 */
public class SynchTest implements Runnable{

    private Integer count = 0;

    public synchronized void get(){
        System.out.println(Thread.currentThread().getId());
        set();
    }
    public synchronized void set(){
        System.out.println(Thread.currentThread().getId());
    }

    public  void lockMethodCode() {

        if (count > 0) {
            System.out.printf("lock method code out");
        }
        synchronized (this) {
            if (count == 0) {
                System.out.printf("lock method code inner");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.printf("lock method code excetption");
                }
            }
        }
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

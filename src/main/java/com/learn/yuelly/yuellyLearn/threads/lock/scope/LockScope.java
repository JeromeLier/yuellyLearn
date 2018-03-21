package com.learn.yuelly.yuellyLearn.threads.lock.scope;

/**
 * Created by ll_yue on 2018/3/21.13:53
 */
public class LockScope implements Runnable{

    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
    public static void main(String[] args) {
        LockScope t1 = new LockScope();
        Thread ta = new Thread(t1, "A");
        //LockScope t2 = new LockScope();
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }
}

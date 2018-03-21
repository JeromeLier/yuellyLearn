package com.learn.yuelly.yuellyLearn.threads.lock.scope;

/**
 * Created by ll_yue on 2018/3/21.13:53
 */
public class LockScope1{

    public void m4t1() {
        synchronized(this) {
            int i = 5;
            while( i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
    public void m4t2() {
        // 不加synchnized 可以并行，加了就只能阻塞等待。
            int i = 5;
            while( i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
    }

    public void m4t3() {
        // 持有了是当前的对象锁
        synchronized(this) {
            int i = 5;
            while( i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }

    }

    public synchronized void m4t4() {
        // 不加synchnized 可以并发，加了就只能阻塞等待。

        int i = 5;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final LockScope1 myt2 = new LockScope1();
        Thread t1 = new Thread(  new Runnable() {  public void run() {  myt2.m4t1();  }  }, "t1"  );
        Thread t2 = new Thread(  new Runnable() {  public void run() { myt2.m4t2();   }  }, "t2"  );


        Thread t3 = new Thread(  new Runnable() {  public void run() { myt2.m4t3();   }  }, "t3"  );
        final LockScope1 myt3 = new LockScope1();
        Thread t4 = new Thread(  new Runnable() {  public void run() { myt2.m4t4();   }  }, "t4"  );
        Thread t5 = new Thread(  new Runnable() {  public void run() { myt3.m4t4();   }  }, "t5"  );

        // t1 t2 可以并发
        t1.start();
        t2.start();
        // 只有当t1 t2 执行完， t3 才可以执行
        t3.start();
        t4.start();
        // 加载方法上面的锁 也是对象锁。另外一个新的线程也可以执行
        t5.start();


    }
}

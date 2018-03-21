package com.learn.yuelly.yuellyLearn.threads.frame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.learn.yuelly.yuellyLearn.threads.base.MyRunThread;

/**
 * Created by ll_yue on 2018/3/16.14:41
 *
 */
public class ExecutorsMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new MyRunThread());

        executorService.submit(new MyRunThread());
        executorService.submit(new MyRunThread());
        executorService.submit(new MyRunThread());
        executorService.submit(new MyRunThread());
        executorService.submit(new MyRunThread());

        executorService.shutdown();

    }
}

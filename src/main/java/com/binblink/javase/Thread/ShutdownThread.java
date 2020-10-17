package com.binblink.javase.Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author:binblink
 * @Description 安全的终止线程（ 中断线程） 不能使用过期的stop() suspend() resume();
 *                因为这三个方法容易造成死锁
 * @Date: Create on  2018/10/9 23:21
 * @Modified By:
 * @Version:1.0.0
 **/
public class ShutdownThread {



    public static void main(String[] args) throws InterruptedException {

        //分别使用中断和标志位的方式 终止线程
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
    // 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(countThread.getState());
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
    // 睡眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(countThread.getState());



    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i = " + i);
        }
        public void cancel() {
            on = false;
        }
    }


}

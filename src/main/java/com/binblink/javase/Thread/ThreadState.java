package com.binblink.javase.Thread;


import java.util.concurrent.TimeUnit;

/**
 * @author:binblink
 * @Description 线程的六种状态 NEW RUNNABLE BLOCKED WAITING TIEMW-WAITING TERMINATED
 * @Date: Create on  2018/10/9 0:14
 * @Modified By:
 * @Version:1.0.0
 **/
public class ThreadState {


    public static void sleeptime(long seconds) {

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }

    }

    public static void main(String[] args) {

        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new TimeWaiting (), "TimeWaitingThread");
        new Thread(new Waiting(), "WaitingThread").start();
    // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();



    }

    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                sleeptime(10000);
            }
        }
    }

    static class Waiting implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    // 该线程在Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {

                    sleeptime(100);
                }
            }
        }
    }

}

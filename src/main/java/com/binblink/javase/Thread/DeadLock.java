package com.binblink.javase.Thread;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author binblink
 * @version 1.0.0
 * @Date 2020/9/30 15:20
 * @Description 死锁演示 会导致系统功能不可用，中业务上 是可感知的
 *
 * 避免死锁的方法：
 *
 * ·避免一个线程同时获取多个锁。
   ·避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。
   ·尝试使用定时锁，使用lock.tryLock（timeout）来替代使用内部锁机制。
   ·对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况。
 **/
public class DeadLock {

    private static String A = new String("a");

    private static String B = new String("a");

    private void deadLock() {
//        LinkedTransferQueue
        Thread t1 = new Thread(() -> {

            synchronized (A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }

        });
        Thread t2 = new Thread(() -> {

            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }

        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
//        new DeadLock().deadLock();
        System.out.println(new DeadLock().hashCode());
    }
}

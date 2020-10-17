package com.binblink.javase.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:binblink
 * @Description A.join 执行A.join()的线程必须等待A 执行结束后才能执行，顾名思义也就是A 线程join（加了）进来
 * @Date: Create on  2018/10/15 0:34
 * @Modified By:
 * @Version:1.0.0
 **/
public class Join {


    public static void main(String[] args) throws InterruptedException {

        Thread previous = Thread.currentThread();
        // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
        for(int i = 0; i <10;i++) {
           Thread thread = new Thread(new Domino(previous),"Thread - "+ i);
           thread.start();

           previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);

        System.out.println(Thread.currentThread().getName() + " terminate.");

//        Thread.currentThread().join();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable{

        private Thread previour;
//       ReentrantLock
        Domino(Thread thread){
            this.previour = thread;
        }

        @Override
        public void run() {
//            try {
//                previour.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " terminate");
        }
    }
}

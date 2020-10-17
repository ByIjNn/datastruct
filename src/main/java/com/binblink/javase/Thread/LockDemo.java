package com.binblink.javase.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
*
* @author binblink
* @Date 2020/10/11 23:17
* @version 1.0.0
* @Description Lock 的使用  线程切换 打印
*
**/
public class LockDemo {

    private int i = 0;

    //可重入锁
    private ReentrantLock lock = new ReentrantLock();

    //奇数条件
    private Condition oddCondition = lock.newCondition();


    //偶数条件
    private Condition evenCondition = lock.newCondition();


    private void printOdd(){
        lock.lock();
        try {
            while(i<100){
                if(i%2 == 0){
                    //当前线程进入释放锁 进入等待状态，并进入oddCondition 的等待队列
                    oddCondition.await();
                }

                System.out.println(Thread.currentThread().getName()+"---------i:"+i);
                Thread.sleep(200);//突出显示效果
                i++;
                //唤醒evenCondition等待队列中的线程，参与竞争锁
                evenCondition.signal();

            }

        } catch (InterruptedException e) {
            System.out.println("中断了");
//            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private void printEven(){
        lock.lock();
        try {
            while(i<100){
                if(i%2 == 1){
                    evenCondition.await();
                }

                System.out.println(Thread.currentThread().getName()+"---------i:"+i);
                Thread.sleep(200);//突出显示效果
                i++;
                oddCondition.signal();

            }

        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();

        Thread t1  = new Thread(()->{
            lockDemo.printOdd();
        },"Thread odd");

        t1.start();

        new Thread(()->{
            lockDemo.printEven();
        },"Thread even").start();

        Thread.sleep(1000);

//        t1.interrupt();


    }
}

package com.binblink.javase.Thread;

import org.junit.jupiter.api.Test;

/**
*
* @author binblink
* @Date 2020/10/11 23:02
* @version 1.0.0
* @Description synchronized 轻量级锁  语法  三种使用方式
 * 锁的获取 释放都为隐式进行的
*
**/
public class SynchronizedDemo {

    private int i = 0;

    private static int m = 0;

    private Object lock = new Object();

    //修饰方法 此时锁为 SynchronizedDemo 的对象
    public synchronized void addOne(){
        i++;
        System.out.println(Thread.currentThread().getName()+"--------i:"+i);
    }

    //代码块 可以指定任意对象 作为锁
    public void addTwo(){

        synchronized (lock){
            i = i + 2;
            System.out.println(Thread.currentThread().getName()+"--------i:"+i);
        }
    }

    // 修饰静态方法 此时锁为 SynchronizedDemo.class 的对象
    public static synchronized void addThree(){
       m++;
        System.out.println(Thread.currentThread().getName()+"--------m:"+m);
    }

    /**
    *
    * @author binblink
    * @Description synchronized 为可重入锁，已获取锁的线程 再去获取锁时不会阻塞 而直接获取锁
     * 此处递归 会多次获取锁
    *
    **/
    public synchronized int add(){

        i++;

        if(i>=10){
            return i;
        }
        return add();
    }

    // 同对象
    @Test
    public void test1(){
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        new Thread(()->{
            synchronizedDemo.addOne();
        },"Thread 1").start();

        new Thread(()->{
            synchronizedDemo.addOne();
        },"Thread 2").start();
    }

    // 不同对象
    @Test
    public void test2(){
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();
        new Thread(()->{
            synchronizedDemo.addOne();
        },"Thread 1").start();

        new Thread(()->{
            synchronizedDemo2.addOne(); // 不同对象
        },"Thread 2").start();
    }

    public static void main(String[] args) {

        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.add();
        System.out.println(synchronizedDemo.i);

        new Thread(()->{
            SynchronizedDemo.addThree();
        },"Thread 1").start();

        new Thread(()->{
            SynchronizedDemo.addThree();
        },"Thread 2").start();

    }

}

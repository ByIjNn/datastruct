package com.binblink.javase.Thread;

/**
*
* @author binblink
* @Date 2020/10/11 22:46
* @version 1.0.0
* @Description synchronized  wait/notify机制演示
 * 两个线程 切换打印
*
**/
public class WaitNotifyTest {

    private int i = 0;

    //打印奇数
    public synchronized  void printOdd() throws InterruptedException {

        while(i<100){
            if(i%2 == 0){
                this.wait();
            }else{
                System.out.println(Thread.currentThread().getName()+"---------i:"+i);
                Thread.sleep(200);//突出显示效果
                i++;
                this.notify();
            }


        }
    }

    //打印偶数
    public synchronized  void printEven() throws InterruptedException {

        while(i<=100){
            if(i%2 == 1){
                this.wait();
            }else{
                System.out.println(Thread.currentThread().getName()+"---------i:"+i);
                Thread.sleep(200);//突出显示效果
                i++;
                this.notify();
            }


        }

    }

    public static void main(String[] args) {

        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();

        Thread t1 = new Thread(()->{
            try {
                waitNotifyTest.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread print Odd");

        Thread t2 = new Thread(()->{
            try {
                waitNotifyTest.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread print Even");

        t1.start();
        t2.start();
    }
}

package com.binblink.javase.Thread;

/**
 * @author:binblink
 * @Description volatile 只保证变量的可见性；不保证原子性 验证
 *                  多线程下无法保证原则性原因：i++非原子操作 在不同线程中 有的可能已经完成+1操作 但未写回缓存时，即使被其他已经写回缓存的的线程 置为无效（缓存一致性MESI），
 *                  不会读取主内存中的最新值，因为程序已经走到写回这一步了，+1后的值存在寄存器中，再次获得时间片执行时，将寄存器的值写回高速缓存，触发
 *                  缓存一致性机制，写回主内存。导致少加的情况。
 * @Date: Create on  2018/10/11 23:15
 * @Modified By:
 * @Version:1.0.0
 **/
public class VolatileTest {

    private static volatile int i;


    public static void main(String[] args) {


        for(int k = 0;k<10;k++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int m = 0;m<10;m++){

                        i++;
                        System.out.println(" i = "+i+ "------"+Thread.currentThread().getName());
                    }
                }
            }).start();
        }

    }
}

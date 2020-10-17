package com.binblink.javase.Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author:binblink
 * @Description ThreadLocal 是一个用于保存线程私有变量的数据结构，可以在同一线程 执行的的不同方法中 传递参数
 *                可以理解为线程级别的共享变量(如web中 request域 、session域)。应用 AOP计算性能时间等
 * @Date: Create on  2018/10/15 23:25
 * @Modified By:
 * @Version:1.0.0
 **/
public class ThreadLocalTest {


    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){

        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }

    };

    private static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    private static final  long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ThreadLocalTest.end() + " mills");
    }
}

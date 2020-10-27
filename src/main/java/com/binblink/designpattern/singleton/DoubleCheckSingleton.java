package com.binblink.designpattern.singleton;

import java.util.Objects;

/**
*
* @author binblink
* @Date 2020/10/27 23:14
* @version 1.0.0
* @Description 双重检测懒汉式单例
*
**/
public class DoubleCheckSingleton {

    /**
     * 由于new DoubleCheckSingleton() 不是原子操作 会存在指令重排，可能会导致对象地址已存在
     * 但是对象未初始化的情况(第一层判空直接返回)，因此利用volatile 来禁止指令重排
     **/
    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton(){

    }

    public  static DoubleCheckSingleton getDoubleCheckSingleton(){

        //第一层判空是为了 单例实例生成后 如果还有很多线程调用此方法，则不会进入锁竞争阶段 提高性能
        if(Objects.isNull(DoubleCheckSingleton.class)){

            synchronized (DoubleCheckSingleton.class){
                //第二层判空  是生成逻辑，单例实例未生成,则去生成
                if(!Objects.isNull(doubleCheckSingleton)){

                    doubleCheckSingleton =  new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}

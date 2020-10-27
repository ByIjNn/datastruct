package com.binblink.designpattern.singleton;

/**
*
* @author binblink
* @Date 2020/10/27 23:11
* @version 1.0.0
* @Description 枚举实现单例 由jvm保证线程安全的
*
**/
public enum SingletonEnum {

    SINGLETON_ENUM;

    private SingletonEnum(){

    }

    public SingletonEnum getSingletonEnum(){
        return SINGLETON_ENUM;
    }
}

package com.binblink.designpattern.singleton;

/**
*
* @author binblink
* @Date 2020/10/27 23:37
* @version 1.0.0
* @Description 饿汉式 单例 无法懒加载
*
**/
public class HungerySingelton {

    private HungerySingelton hungerySingelton = new HungerySingelton();

    private HungerySingelton(){

    }

    public HungerySingelton getHungerySingelton(){
        return this.hungerySingelton;
    }
}

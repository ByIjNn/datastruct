package com.binblink.designpattern.proxy;

/**
*
* @author binblink
* @Date 2020/10/27 23:02
* @version 1.0.0
* @Description 我的房子要出租
*
**/
public class Myhouse implements Rent {
    @Override
    public void rent() {

        System.out.println("我的房子要出租！");
    }

    @Override
    public void rent2() {
        System.out.println("第二套房子要出租！");
    }
}

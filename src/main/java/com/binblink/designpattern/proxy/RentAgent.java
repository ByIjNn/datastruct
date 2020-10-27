package com.binblink.designpattern.proxy;

/**
 * @author binblink
 * @version 1.0.0
 * @Date 2020/10/27 23:03
 * @Description 以房子中介为例 理解代理模式，并且此为静态代理模式
 **/
public class RentAgent implements Rent {

    private Myhouse myhouse;

    //持有房源
    public RentAgent(Myhouse myhouse) {
        this.myhouse = myhouse;
    }

    //中介出租 收取中介费
    @Override
    public void rent() {

        System.out.println("中介收费啦！");
        //实际房主出租
        myhouse.rent();
    }

    @Override
    public void rent2() {

    }

    public static void main(String[] args) {

        Rent rent = new RentAgent(new Myhouse());
        //房子出租啦
        rent.rent();

    }
}

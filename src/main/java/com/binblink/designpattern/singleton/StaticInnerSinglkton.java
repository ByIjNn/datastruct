package com.binblink.designpattern.singleton;

/**
 * @author binblink
 * @version 1.0.0
 * @Date 2020/10/27 23:40
 * @Description 内部静态类单例 懒汉式
 **/
public class StaticInnerSinglkton {


    private StaticInnerSinglkton() {
    }

    //外部类加载时并不需要立即加载内部类
    private static class Inner {
        private static StaticInnerSinglkton staticInnerSinglkton = new StaticInnerSinglkton();
    }


    //只有在第一次调用时 才会加载Inner类 然后由jvm的类加载保证线程安全
    public StaticInnerSinglkton getStaticInnerSinglkton() {
        return Inner.staticInnerSinglkton;
    }
}

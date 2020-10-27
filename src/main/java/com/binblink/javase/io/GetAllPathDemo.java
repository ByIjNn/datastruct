package com.binblink.javase.io;

import java.net.URL;

/**
 * @author binblink
 * @version 1.0.0
 * @Date 2020/10/26 13:56
 * @Description 获取各种路径的方法
 **/
public class GetAllPathDemo {

    public static void main(String[] args) {

        URL resource = GetAllPathDemo.class.getResource("/");
        // classpath+该类所在路径
        URL resource1 = GetAllPathDemo.class.getResource("");
        // classpath目录下
        URL resource2 = GetAllPathDemo.class.getClassLoader().getResource("");
        // null
        URL resource3 = GetAllPathDemo.class.getClassLoader().getResource("/");

        System.out.println(resource);
        System.out.println(resource1);
        System.out.println(resource2);
        System.out.println(resource3);
    }


}

package com.binblink.javase.Thread.ThreadApplicationDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author:binblink
 * @Description 一个sql 连接驱动 （模拟）
 * @Date: Create on  2018/10/18 21:58
 * @Modified By:
 * @Version:1.0.0
 **/
public class ConnectionDriver {

    //内部静态类 代理
     static class ConnectionHandler implements InvocationHandler{

         @Override
         public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
             if (method.getName().equals("commit")) {
                 TimeUnit.MILLISECONDS.sleep(100);
                 System.out.println("hahahahaha");
             }
             return null;
         }
     }

     public static final Connection createConnection(){

         return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class[] { Connection.class },new ConnectionHandler());
     }
}

package com.binblink.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
*
* @author binblink
* @Date 2020/10/27 23:54
* @version 1.0.0
* @Description 动态代理：运行时生产一个代理类
 * JDK 动态代理的实现 可以直接代理某个类，
 * 前提是那个类有实现接口（缺点），spring中实现了接口的类使用jdk代理，没有接口使用cglib动态代理
*
**/
public class JDKDynamicProxy  {

    //实现InvocationHandler接口，并且可以初始化被代理类的对象
    static class MyHandler implements InvocationHandler {
        private Object proxy;
        public MyHandler(Object proxy) {
            this.proxy = proxy;
        }

        //自定义invoke方法
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("看房");
            //真正调用方法的地方
            Object ret = method.invoke(this.proxy, args);
            System.out.println("收钱");
            return ret;
        }
    }

    //返回一个代理对象
    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                new MyHandler(proxy));
    }

    public static void main(String[] args) {

        Rent rent = (Rent) JDKDynamicProxy.agent(Rent.class,new Myhouse());
        rent.rent2();
    }
}

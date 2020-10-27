package com.binblink.designpattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
*
* @author binblink
* @Date 2020/10/28 0:15
* @version 1.0.0
* @Description cglib动态代理 能够代理任何一个类
*
**/
public class CglibDynamicProxy implements MethodInterceptor {

    private Object proxy;

    public Object getInstance(Object proxy) {
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }
    //回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("看房");
        //真正调用
        Object ret = methodProxy.invokeSuper(o, objects);
        System.out.println("收钱");
        return ret;
    }

    public static void main(String[] args) {

        CglibDynamicProxy cGlibAgent = new CglibDynamicProxy();
        Rent rent = (Rent) cGlibAgent.getInstance(new Myhouse());
        rent.rent();
        rent.rent2();

    }
}

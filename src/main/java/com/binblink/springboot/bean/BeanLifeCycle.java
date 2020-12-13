package com.binblink.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/11 17:37
 **/
public class BeanLifeCycle implements BeanFactoryAware,BeanNameAware,
        BeanPostProcessor,InitializingBean,DisposableBean {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name 属性注入！");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("age 属性注入！");
        this.age = age;
    }



    public BeanLifeCycle(){
        System.out.println("我是构造器！");
    }


    public void init(){
        System.out.println("xml上的init方法");
    }


    public void destroyxml(){
        System.out.println("xml上的destroy方法");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("设置bean name!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("这是InitializingBean的afterPropertiesSet");
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitialization:beanName---" + beanName);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessAfterInitialization:beanName---" + beanName);
        return bean;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("这是DisposableBean的destroy方法");
    }
}

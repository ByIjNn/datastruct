package com.binblink.spring;


import com.binblink.datastructure.list.SingleLinkedList;
import com.binblink.springboot.bean.BeanLifeCycle;
import com.binblink.springboot.bean.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;


public class GetBean {


//    @Test
//    public void getbeanTest1() {
//
//        String path = "classpath:application-spring.xml";
//
//        ApplicationContext xmlApplicationContext =
//                new ClassPathXmlApplicationContext(path);
//        SingleLinkedList singleLinkedList = (SingleLinkedList) xmlApplicationContext.getBean("list");
//
//        singleLinkedList.add(3);
//
//        ArrayList list = (ArrayList) xmlApplicationContext.getBean("list2");
//        System.out.println(list);
//        System.out.println(singleLinkedList.size() + "" + singleLinkedList.get(1));
//    }

    /**
    *
    * @Date 2020/10/28 0:54
    * @version 1.0.0
    * @Description
    *
    **/
//    @Test
//    public void testDog(){
//        String path = "classpath:application-spring.xml";
//
//        ApplicationContext app =
//                new ClassPathXmlApplicationContext(path);
//        Dog dog = (Dog) app.getBean("dog");
//
//    }

    @Test
    public void lifecycle(){

        String path = "classpath:application-spring.xml";

        ApplicationContext app =
                new ClassPathXmlApplicationContext(path);

        BeanLifeCycle beanLifeCycle = (BeanLifeCycle) app.getBean("baenlife");


    }


//    public static void main(String[] args) {
//        String path = "classpath:application.xml";
//
//        ClassPathXmlApplicationContext xmlApplicationContext =
//                new ClassPathXmlApplicationContext(path);
//        SingleLinkedList singleLinkedList = (SingleLinkedList) xmlApplicationContext.getBean("list");
//    }
}

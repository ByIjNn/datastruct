package com.binblink.javase.lambda;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author binblink
 * @Create Time　2019/11/1 21:33
 * @Description: labmda 的java语法各种简写形式,种类为
 *  接口方法中 有无返回值，单个参数、多个参数、无参数之间的排列组合
 */
public class LamdaTest2 {

    private static int add(int a,int b){

        return a+b;
    }

    public void sayhello(){
        System.out.println("hello!");
    }

    /**
     * 不同调用 实现
     */
    @Test
    public void test(){
        ReturningParam returningParam = (a,b) -> add(a,b);
        System.out.println(returningParam.method(3,4));
    }

    /**
     * 类名::静态方法名
     */
    @Test
    public void test2(){
        ReturningParam returningParam =LamdaTest2::add;
        System.out.println(returningParam.method(5, 5));

    }

    /**
     * 对象::实例方法名
     */
    @Test
    public void test3(){
        LamdaTest2 lamdaTest2 = new LamdaTest2();
        NotReturningNotParam notReturningNotParam = lamdaTest2 ::sayhello;
        notReturningNotParam.method();
    }

    /**
     * 构造器方法引用
     * 方式一
     */
    @Test
    public void test4(){
        ConstructorCreater constructorCreater = ()-> new ArrayList(10);
        List list =  constructorCreater.getList();
        list.stream();
        System.out.println(list.size());
    }

    /**
     * 构造器方法引用2
     * 方式二
     */
    @Test
    public void test5(){
        ConstructorCreater2 constructorCreater = String::new;
        constructorCreater.getString("dasd");
    }
}

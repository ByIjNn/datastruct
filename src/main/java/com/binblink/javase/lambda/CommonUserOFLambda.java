package com.binblink.javase.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @Author binblink
 * @Create Time　2019/11/1 22:36
 * @Description:
 */
public class CommonUserOFLambda {

    /**
     * 创建线程
     */
    @Test
    public void test(){
        new Thread(()->{
            System.out.println("Thread-1");
        }).start();

        new Thread(() ->{
            System.out.println("Thread-2");
        }).start();

        //等价于

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread-1");
//            }
//        }).start();
    }

    /**
     * 遍历集合
     */
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(15);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        //遍历集合
//        list.forEach(System.out::println);

        list.forEach(ele ->{
            if(ele%2 == 0){
                System.out.println(ele);
            }
        });
    }

    /**
     * 集合排序
     */
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(15);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        list.sort((o1,o2)->o1 - o2);
        System.out.println(list);

    }

    /**
     * 集合删除 元素
     */
    @Test
    public void test3(){
        ArrayList<String> list = new ArrayList<>(10);
        list.add("fsdfs");
        list.add("fsd");
        list.add("ggg");
        list.add("we");
        list.add("dhfh");

        list.removeIf((ele)->ele.equals("we"));
        list.forEach(System.out::println);

    }

    /**
     * 闭包问题 我们在匿名内部类中也会存在，如果我们把注释放开会报错，告诉我 num 值是 final 不能被改变。
     * 这里我们虽然没有标识 num 类型为 final，
     * 但是在编译期间虚拟机会帮我们加上 final 修饰关键字。
     */
    @Test
    public void test4(){

        int num = 10;
//        num = num + 2; //放在这里没问题
        Consumer<String> consumer = ele -> {
            System.out.println(num);
        };

//        num = num + 2;
        consumer.accept("hello");
    }
}

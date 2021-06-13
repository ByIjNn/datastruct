package com.binblink.javase.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author binblink
 * @Date 2021/6/3 14:29
 */
public class CollectionTest {

    @Test
    public void defaulMethod(){

        List<String> list = new ArrayList();

        list.add("asd");
        list.add("kkk");
        list.add("mm");

        list.removeIf(e ->  e.equals("asd"));
//        list.parallelStream().anyMatch(e->e.contains("a"));
//        List<Integer> list1 = list.stream().map(e->{
//            if("asd".equals(e)){
//                return new Integer(2);
//            }
//            return new Integer(1);
//        }).collect(Collectors.toList());

//        System.out.println(list1);
        System.out.println(list);
    }
}

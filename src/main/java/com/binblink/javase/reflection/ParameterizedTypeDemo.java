package com.binblink.javase.reflection;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
*
* @author binblink
* @Date 2020/10/19 17:37
* @version 1.0.0
* @Description 查看hashmap源码发现 使用了ParameterizedType 获取泛型类型
*
**/
public class ParameterizedTypeDemo {


    List<String> list1;
    List list2;
    Map<String,Long> map1;
    Map map2;
    Map.Entry<Long,Short> map3;

    //获取带有泛型的 类属性
    @Test
    public void test1(){
     Field[] fields =   ParameterizedTypeDemo.class.getDeclaredFields();

     for(Field field : fields){
//         System.out.println(field.getGenericType().getTypeName());
         System.out.println(field.getName()+":"+ (field.getGenericType() instanceof ParameterizedType));
     }
    }

    //获取带有泛型的 类属性
    @Test
    public void test2(){
        Field[] fields =   ParameterizedTypeDemo.class.getDeclaredFields();

        for(Field field : fields){
//         System.out.println(field.getGenericType().getTypeName());
            if(field.getGenericType() instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Type[] types = parameterizedType.getActualTypeArguments();

//                System.out.println("类型名："+ parameterizedType.getTypeName());
//                for(Type type : types){
//                    System.out.println("参数化类型："+type.getTypeName());
//                }
//
//                Type t = parameterizedType.getOwnerType();
//                if(Objects.nonNull(t)){
//
//                    System.out.println("ownType"+t.getTypeName());
//                }
                Type rawType =parameterizedType.getRawType();
                System.out.println("rawType:"+rawType.getTypeName());
            }



        }
    }

    @Test
    public void test3(){
       Type[] typpes = Integer.class.getGenericInterfaces();
       for(Type t : typpes){
           System.out.println(t.getTypeName());
       }
    }

    @Test
    public void test4(){
        ParameterizedType p;
//
//        Type[] types = p.getActualTypeArguments();
//        for(Type type : types ){
//            System.out.println(type.getTypeName());
//        }
    }






}

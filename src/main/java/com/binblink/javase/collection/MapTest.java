package com.binblink.javase.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/12 14:28
 **/
public class MapTest {

    /**
     * map的遍历方式
     */
    @Test
    public void  mapTraverse(){

        Map<String,String> map = new HashMap<>();

        map.put("das","dafs");
        map.put("fd","d23as");
        map.put("fdd","ff");
        map.put("ff","gh");

        //第一种
        Set<String> set = map.keySet();

        for(String s: set){

            System.out.println("key:"+s+", value:"+map.get(s));
        }

        //第二种
        for(Map.Entry<String,String> entry : map.entrySet()){

            System.out.println("key:"+ entry.getKey()+", value:"+entry.getValue());
        }

        // 3. 使用Iterator遍历
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        //第4种
        map.forEach((k,v)->{

            System.out.println("key"+ k+","+"value:"+v);
        });




    }
}

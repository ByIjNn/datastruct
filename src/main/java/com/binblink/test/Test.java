package com.binblink.test;

import com.binblink.datastructure.stack.StackArray;

import java.util.HashMap;


/**
 * @Author binblink
 * @Create Time　2018/2/25 23:36
 * @Description: 测试所写的数据结构
 */
public class Test {

    class A{
        @Override
        public int hashCode() {
            return 1;
        }
    }

    @org.junit.jupiter.api.Test
    public void hashmapTest(){

        HashMap<A,String> map = new HashMap<>(70);
        A a  =  new A();
        A b = new A();
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
//         for(int i =0;i<71;i++){
//             map.put(new A(),"dd"+i);
//         }
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
      map.put(a,"test");

        System.out.println();


    }

    public static void main(String[] args) {

         boolean m = true;
         m = !m;
//        System.out.println(m);
        m = !m;
//        System.out.println(m);

        Integer d = 5;
        Integer g = null;
        Integer k;
        if(( k = d = g)!=null){
            System.out.println(k);
        }
        System.out.println(k);
//        int i = 1;
////        HashMap
//        System.out.println(i^1);
//        System.out.println(0^1);


//        SingleLinkedList<String> mylist = new SingleLinkedList<String>();
//
//        mylist.add("aa");
//        mylist.add("bb");
//        mylist.add("cc");
//
//        String m = mylist.getFirst();
//        System.out.println(mylist.get(1));
//        System.out.println(mylist.get(2));
//        System.out.println(mylist.get(3));
//
//        mylist.remove("cc");
//        System.out.println(mylist.get(2));

//        StackArray<String> kdkd = new StackArray<String>();


//        LinkedList<String> llist = new LinkedList<String>();
//        llist.add("d");
//        System.out.println(llist.get(0));
//        System.out.println((0<0));
//        System.out.println((0>2));

//        StackArray<String> stackArray = new StackArray(4);
//
//
//        stackArray.push("a");
//        stackArray.push("b");
//        stackArray.push("c");
//        stackArray.push("d");
//        stackArray.push("f");
//        stackArray.push("g");
//        stackArray.push("k");
//
//            String s = "dasd";
//        char[] m = s.toCharArray();
//        HashMap

        


//        stackArray.pop();
//        stackArray.pop();

//        System.out.println(stackArray.pop());
//        System.out.println(stackArray.pop());
//        System.out.println(stackArray.pop());
//        System.out.println(stackArray.isEmpty());
//        System.out.println(stackArray.peek());

    }
}

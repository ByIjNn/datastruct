package binblink.test;

import binblink.list.SingleLinkedList;
import binblink.stack.StackArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * @Author binblink
 * @Create Time　2018/2/25 23:36
 * @Description: 测试所写的数据结构
 */
public class Test {

    public static void main(String[] args) {

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

        StackArray<String> stackArray = new StackArray(4);


        stackArray.push("a");
        stackArray.push("b");
        stackArray.push("c");
        stackArray.push("d");
        stackArray.push("f");
        stackArray.push("g");
        stackArray.push("k");

            String s = "dasd";
        char[] m = s.toCharArray();
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

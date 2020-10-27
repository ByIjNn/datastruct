package com.binblink.test;


import com.binblink.datastructure.tree.RedBlackTree;

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
    public void test(){

        A s = new  A();

        A m = s;

        System.out.println(s==m);
//        System.out.println(System.identityHashCode(s));
//        System.out.println(System.identityHashCode(m));

        System.out.println(System.identityHashCode(10));
        System.out.println(System.identityHashCode(10));
//        System.out.println(System.identityHashCode(12));
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

    /**
     * 测试红黑树
     * https://www.cs.usfca.edu/~galles/visualization/RedBlack.html 可以去和这个对比(网站删除时是前驱节点)
     */
    @org.junit.jupiter.api.Test
    public void testRedBlackTree(){
        RedBlackTree<Integer> root = new RedBlackTree();

        root.insert(30);
        root.insert(10);
        root.insert(9);
        root.insert(60);
        root.insert(18);
        root.insert(6);
        root.insert(15);

        root.delete(18);
//        msad.insert(60);

        System.out.println(root.find(30));
    }



    public static void main(String[] args) throws InterruptedException {

        int m =1,k=15,n=13,l=18;

            if(m>1){
                System.out.println("mmmm");
            }else if(k>13){
                System.out.println("kkkk");
            } if(n==13){
                System.out.println("nnnn");
            }


//         boolean m = true;
//         m = !m;
////        System.out.println(m);
//        m = !m;
////        System.out.println(m);
//
//        Integer d = 5;
//        Integer g = null;
//        Integer k;
//        if(( k = d = g)!=null){
//            System.out.println(k);
//        }
//        System.out.println(k);
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

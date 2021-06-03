package com.binblink.javase.base;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/10 19:26
 **/
public class StringTest {


    @Test
    public void stringTets(){

        String s = "a2";

        String m = "a"+"2";

        String mm = new String("a2");

        String ss = new String("a2");

        int k = 2;

        final int l = 2;

        String j = "a" + k;
        String o = "a" + l;

        System.out.println(ss == mm);
        System.out.println(ss == s);
        System.out.println(ss.intern() == s.intern());

        System.out.println(s == m);
        System.out.println(s == j);
        System.out.println(s == o);

    }

    @Test
    public void stringJoinerTest(){
        String separator = "|";
        StringJoiner sj = new StringJoiner(separator);

        sj.add("asdasd");
        sj.add("fsasdad");
        sj.add("feweeeee");

        System.out.println(sj.toString());

    }

    @Test
    public void ascii(){

        char a = 'a';
        char b = 'b';

        char A = 'A';
        char B = 'B';
        char blank = ' ';

        System.out.println(Integer.valueOf(blank));
        System.out.println(Integer.valueOf(a));
        System.out.println(Integer.valueOf(A));

        System.out.println(Integer.valueOf(b));
        System.out.println(Integer.valueOf(B));




    }


    public static void main(String[] args) {
        String m = "dgaesgdjrhlsk";

        System.out.println(indexOf(m, "ep"));

    }

    /**
     * 一个面试题 重写indexOf方法
     * @param ori 源String
     * @param sub 子String
     * @return 存在则返回 sub 首字母第一次出现在原String的下标
     * 不存在返回-1
     */
    public static int indexOf(String ori, String sub) {

        if (sub == null || sub.length() <= -1) {
            return -1;
        }

        if (ori == null || ori.length() <= -1) {
            return -1;
        }

        int subLength = sub.length();
        int oriLength = ori.length();

        if (subLength > oriLength) {
            return -1;
        }

        char[] oriArr = ori.toCharArray();
        char[] subArr = sub.toCharArray();

        int subPosition = 0;

        for (int i = 0; i < oriLength; i++) {

            if (subArr[subPosition] == oriArr[i]) {

                subPosition = subPosition + 1;

                if (subPosition == subArr.length) {

                    return (i - subPosition + 1);
                }

            } else {
                subPosition = 0;

            }
        }
        return -1;
    }
}

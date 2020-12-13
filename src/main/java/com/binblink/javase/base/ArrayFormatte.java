package com.binblink.javase.base;

/**
 * @author binblink
 * @version 1.0.0
 * @Description java创建数组的多种形式
 * @Date 2020/11/10 21:08
 **/
public class ArrayFormatte {

    public static void main(String[] args) {

        int[] arr = new int[6];

        int[] x = {1, 2, 3, 4};

        int[] y = new int[]{1, 2, 3, 4, 5};

        int k[] = {1, 2, 3, 4};


        int d[] = new int[6];

        int j[] = new int[]{1, 2, 3, 4, 5};

        //第一维 一定要赋值
        int[][] mm = new int[10][];

        int kk[][]  = new int[0][];

        System.out.println(k[2]);
    }
}

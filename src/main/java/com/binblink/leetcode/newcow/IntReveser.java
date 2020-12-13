package com.binblink.leetcode.newcow;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/10 20:53
 **/
public class IntReveser {

    public static void reverse(String target){

        char[] charArr = target.toCharArray();
        char[] result = new char[charArr.length];
        int  m = 0;
        for(int i = charArr.length-1; i>=0;--i){
            result[m] = charArr[i];
            m++;
        }
        String resultString = new String(result);
        System.out.println(resultString);
    }

    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while((str=br.readLine())!=null){
                String[] strArr = str.split(" ");
                int n = Integer.parseInt(strArr[0]);
                int m = Integer.parseInt(strArr[1]);
                int j = m*n;
                if(n>m){
                    int temp = m;
                    m = n;
                    n =temp;
                }
                //最大公约数
                while(n!=0){
                    int r = m%n;
                    m = n;
                    n = r;
                }
                int max = j/m;
                System.out.println(max);
            }
        }


//        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.nextInt());
//
//        System.out.println(scanner.nextInt());
//        InputStream stream = System.in;
//        int m;
//        String target = "";
//        byte[] bytes = new byte[1024];
//        while((m = stream.read(bytes))>0){
//            target =  new String(bytes, 0, m - 1);
//        }
//
//        reverse(target);

    }


package com.binblink.leetcode.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description 一个32位有符号整数X 将数字部分反转后返回结果 如果反转超过整数值范围[-2^31,2^31-1] 则返回0
 * 例如 x = 123 输出 x = 321 ; x = -123 输出 x = -321; x = 120 输出 x = 21 ; x = 0 输出x = 0
 *  假设环境不允许 存储64位整数 ---就是不能用long
 * @Author binblink
 * @Date 2021/6/7 9:37
 */
public class ReverseDigital {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputString =  reader.readLine();

        String integerMax = String.valueOf(Integer.MAX_VALUE);
        Integer targetX = Integer.parseInt(inputString);
        char[] targetArr = inputString.toCharArray();
        if(inputString.startsWith("-")){

        }



        System.out.println(targetX);
    }
}

package com.binblink.leetcode.newcow;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/13 11:08
 **/
public class EighSplitString {

    public static void main(String[] args) throws Exception{

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String target ;
//        while((target = reader.readLine()) != null){
//
//            char[] charArr = target.toCharArray();
//            int length = charArr.length;
//            int times = length/8;
//            int last = length%8;
//
//            for(int i = 1;i<=times+1;i++){
//                int start = (i-1)*8;
//                char[] charArrNew  = new char[8];
//                if(i<times+1){
//                    for( int index =0;index<charArrNew.length;index++){
//                        charArrNew[index] = charArr[start];
//                        start++;
//                    }
//                    System.out.println(new String(charArrNew));
//                }
//
//                if( last >0 && i == times+1){
//                    for( int index =0;index<charArrNew.length;index++){
//                        if(start<length){
//                            charArrNew[index] = charArr[start];
//                        }else{
//                            charArrNew[index] = '0';
//                        }
//                        start++;
//                    }
//                    System.out.println(new String(charArrNew));
//                }
//
//            }
//
//        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target ;
        String zoreTemlp = "00000000";
        while((target = reader.readLine()) != null) {

            int length = target.length();
            int times = length / 8;
            int last = length % 8;

            int index = 1;
            while (index <= times) {
                int start = (index - 1) * 8;
                int end = index * 8;
                System.out.println(target.substring(start, end));
                index++;
            }
            Math.pow(32, 1);//计算a的b次方
            if (last > 0) {
                String sub = target.substring(times * 8, times * 8 + last);
                int zore = 8 - last;
                String zero = zoreTemlp.substring(0, zore);
                System.out.println(sub+zero);
            }
        }
    }

    public static long factorial(int n){
        long num = 16;

        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 16;
        }


        for(;n>=2;n--){
            num = 16 * num;
        }

        return num;
    }

    @Test
    public void test() throws IOException {


        HashMap<Character,Integer> mapTemple = new HashMap(15);

        mapTemple.put('0',0);
        mapTemple.put('1',1);
        mapTemple.put('2',2);
        mapTemple.put('3',3);
        mapTemple.put('4',4);
        mapTemple.put('5',5);
        mapTemple.put('6',6);
        mapTemple.put('7',7);
        mapTemple.put('8',8);
        mapTemple.put('9',9);
        mapTemple.put('A',10);
        mapTemple.put('B',11);
        mapTemple.put('C',12);
        mapTemple.put('D',13);
        mapTemple.put('E',14);
        mapTemple.put('F',15);



        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bReader.readLine())!=null){
            int index = 0;
            char[] charArr = str.toCharArray();
            Integer result  = 0;
            for(int m = str.length()-1;m>=0;m--){
                Integer value = mapTemple.get(new Character(charArr[m]));

                if(value != null){
                    result = result + (int)Math.pow(16, index)*value;
                }
                index ++;
            }
            System.out.println(result);

        }
    }

    @Test
    public void test2() throws IOException{
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bReader.readLine())!=null){
            Integer num = Integer.parseInt(str);
            int m = 0;
            int result = 0;
            if(num>=10){
                result = result + (num/10)*5;
                num = num % 10;
            }

            if(0< num && num <10){
                result = result + (num/2);
            }

            System.out.println(result);

        }
    }
}

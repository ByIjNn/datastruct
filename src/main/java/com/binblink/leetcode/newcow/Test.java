package com.binblink.leetcode.newcow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/16 23:15
 **/
public class Test {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        String[] m = str.split(" ");

        int h = Integer.parseInt(m[0]);
        int l = Integer.parseInt(m[1]);

        int position = 0;

        int[][] map = new int[h][l];

        int huax = -1;
        int huay = -1;

        int mingx = -1;
        int mingy = -1;

        for(int i = 0; i<h;i++){

            String line = reader.readLine();
            String[] lineArr = line.split(" ");

            for(int k = 0; k<l;k++){
                int per = Integer.parseInt(lineArr[k]);
                map[i][k] = per;

                if(per == 3){
                    position ++;
                }

                if(per == 2){
                    if(huax == -1){
                        huax = i;
                        huay = k;
                    }else{
                        mingx = i;
                        mingy = k;
                    }
                }
            }
        }





    }




     public static int func( int n)
        {
            if(n == 1){
                return 0;

            }
            if(n % 2 == 0){
                return 1 + func(n/2);
            }
            int x = func(n + 1);
            int y = func(n - 1);
            if(x > y){
                return y+1;
            } else{

                return x+1;
            }

    }


    @org.junit.jupiter.api.Test
    public void test3(){
//        func(6564);
        System.out.println(func(6564));
    }
}

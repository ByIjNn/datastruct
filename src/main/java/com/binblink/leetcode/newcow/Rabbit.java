package com.binblink.leetcode.newcow;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/13 15:56
 **/
public class Rabbit {

    //有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
    // 假如兔子都不死，问每个月的兔子总数为多少？
    @Test
    public void test1() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String mstr = "";
        while((mstr = reader.readLine())!= null){

            Integer month = Integer.parseInt(mstr);
            int[] monthmark = new int[3];

            for(int i =1;i<=month;i++){

                if(i == 1){
                    monthmark[0] =  1;
                    continue;
                }
                monthmark[2] = monthmark[1] + monthmark[2];
                monthmark[1] = monthmark[0];
                monthmark[0] =  monthmark[2];
            }

            System.out.println( monthmark[0]+ monthmark[1]+ monthmark[2]);

        }
    }
}

package com.binblink.leetcode.newcow;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/15 1:37
 **/
public class Main2 {

    //0 不是字母 小写为处理后的值
    public static int isAZ(char c){

        if(('a'<=c && c<= 'z')){
            int v = c - 32;
             return v;
        }

        if(('A'<=c && c<= 'Z')){
            int m = c ;
            return m ;
        }

        return 0;
    }

    @Test
    public void test() throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        str=bReader.readLine();
        char[] strArr = str.toCharArray();

        int le = strArr.length;
        for(int i = 0; i<le;i++){
            char c = strArr[i];
            int tempc = isAZ(c);
            if(tempc > 0){

                int noaznumb = 0;
                for(int j = i-1;j>=0;j--){

                     char pre = strArr[j] ;
                    int temppre = isAZ(pre);

                     if( temppre == 0){
                        noaznumb ++;
                        continue;
                    }

                    if(tempc >= temppre){
                        strArr[j+1+noaznumb] = c;
                        break;
                    }else{
                        strArr[j+1+noaznumb] = strArr[j];
                        strArr[j] = c;
                        noaznumb = 0;
                    }
                }
            }

        }

        System.out.println(new String(strArr));

    }

    /**
     * 动态规划
     * 题目描述
     王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
     主件	附件
     电脑	打印机，扫描仪
     书柜	图书
     书桌	台灯，文具
     工作椅	无
     如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
     设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
     v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
     请你帮助王强设计一个满足要求的购物单。




     输入描述:
     输入的第 1 行，为两个正整数，用一个空格隔开：N m

     （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）


     从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q


     （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）




     输出描述:
     输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str.split(" ")[0])/10;
        int m = Integer.parseInt(str.split(" ")[1]);
        int[] v= new int[m+1];
        int[] p= new int[m+1];
        int[] q= new int[m+1];

        int[][] res = new int[m+1][N+1];
        for (int i = 1; i <= m; i++) {
            String[] strings = br.readLine().split(" ");
            v[i] = (Integer.parseInt(strings[0]))/10;
            p[i] = Integer.parseInt(strings[1]) * v[i];
            q[i] = Integer.parseInt(strings[2]);
        }

        for (int i = 1; i <= m; i++) {
            for(int j = 1; j<=N; j++){
                if(q[i] == 0) {
                    if(v[i] <= j){
                        res[i][j] = Math.max(res[i-1][j], res[i-1][j-v[i]] + p[i]);
                    }
                }else{
                    if(v[i] + v[q[i]] <= j){
                        res[i][j] = Math.max(res[i-1][j], res[i-1][j-v[i]-v[q[i]]] + p[i]);
                    }
                }
            }
        }

//        for (int i = 1; i <= m; i++) {
//            for(int j = 1; j<=N; j++){
//
//                System.out.print(res[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println("");
//        }
        System.out.println(res[m][N] * 10);
    }

    /**
     * 质因数分解
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int sum = Integer.valueOf(str);
            for (int i = 2; i <= Math.sqrt(sum) ; i++) {
                if (sum % i ==0) {
                    sb.append(i+" ");
                    sum/=i;
                    i--;
                }
            }
            sb.append(sum+" ");
            System.out.println(sb.toString());
        }
    }

    @Test
    public void test4() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hashmap = new HashMap(60);
        String[] last = new String[8];
        int lastposition = -1;
        String target ;
        while(null != (target = reader.readLine())){

            String[] str = target.split(" ");
            String filename =  str[0].substring(str[0].lastIndexOf("\\")+1,str[0].length());

            if(filename.length()>16){
                filename = filename.substring(filename.length()-16,filename.length());
            }
            String key = filename+ " " + str[1];

            if(hashmap.containsKey(key)){
                int v = hashmap.get(key)+1;
                hashmap.put(key,v);
            }else{
                hashmap.put(key,1);
            }

            for(int i = 0;i<last.length;i++){
                if(last[i] == null){
                    last[i] = key;
                    lastposition++;
                    break;
                }else{
                    if(key.equals(last[i])){

                        for(;i<=lastposition-1;i++){
                            last[i]= last[i+1];
                        }
                        last[lastposition] = key;
                        break;
                    } else{
                        if(i == 7 && last[i] != null){

                            for(int k =0;k<=6;k++){
                                last[k]= last[k+1];
                            }
                            last[7] = key;
                        }
                    }


                }

            }

        }

        for(String s :last){
            System.out.println(s+ " " + hashmap.get(s));
        }
    }

    @Test
    public void test6() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while((str = br.readLine()) != null) {
            int a = str.lastIndexOf('\\');
            int b = str.lastIndexOf(' ');
            String key = str.substring(b - a > 16 ? b - 16 : a + 1);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(i >= map.size() - 8) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            i++;
        }
    }
}

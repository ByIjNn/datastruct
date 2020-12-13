package com.binblink.leetcode.newcow;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/16 21:40
 **/
public class IpCount {

    public static long getIpvalue(String ip){


        String[] iparr = ip.split("\\.");

        long firstp = Long.parseLong(iparr[0]) << 24;
        long secondp = Long.parseLong(iparr[1]) << 16;
        long thirdp = Long.parseLong(iparr[2]) << 8;
        long fourp = Long.parseLong(iparr[3]);

        return firstp+secondp+thirdp+fourp;
    }

    public static boolean checkMask(String marsk){

        String[] iparr = marsk.split("\\.");
        String firstp = Integer.toBinaryString(Integer.parseInt(iparr[0]));
        String secondp = Integer.toBinaryString(Integer.parseInt(iparr[1]));
        String thirdp = Integer.toBinaryString(Integer.parseInt(iparr[2]));
        String fourp = Integer.toBinaryString(Integer.parseInt(iparr[3]));
        String full = firstp+secondp+thirdp+fourp;

        System.out.println(full);
        return full.lastIndexOf('1') < full.indexOf('0');
    }

    @Test
    public void test1() throws IOException {
//        checkMask("252.255.254.255");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String m = reader.readLine();
//        m.indexOf()
        int line = Integer.parseInt(m);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<line;i++){
            String str = reader.readLine();

            String[] tar = str.split(" ");
            Integer key = Integer.parseInt(tar[0]);
            Integer value = Integer.parseInt(tar[1]);
            if(map.containsKey(key)){
                value = map.get(key)+value;

            }
            map.put(key,value);
        }

        Set<Integer> set =  map.keySet();
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);

        for(Integer key : result){
            System.out.println(key+ " " + map.get(key));
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long legaldown = 0;
        long legalup = getIpvalue("255.255.255.255");

        long Adown = getIpvalue("1.0.0.0");
        long Aup= getIpvalue("126.255.255.255");

        long Bdown = getIpvalue("128.0.0.0");
        long Bup= getIpvalue("191.255.255.255");

        long Cdown = getIpvalue("192.0.0.0");
        long Cup= getIpvalue("223.255.255.255");

        long Ddown = getIpvalue("224.0.0.0");
        long Dup= getIpvalue("239.255.255.255");

        long Edown = getIpvalue("240.0.0.0");
        long Eup= getIpvalue("255.255.255.255");

        long per1down = getIpvalue("10.0.0.0");
        long per1up= getIpvalue("10.255.255.255");
        long per2down = getIpvalue("172.16.0.0");
        long per2up= getIpvalue("172.31.255.255");
        long per3down = getIpvalue("192.168.0.0");
        long per3up= getIpvalue("192.168.255.255");

        int a = 0;
        int b = 0;
        int c =0;
        int d =0;
        int e =0;
        int error = 0;
        int personal =0;
        int k = 0;
        String ipstr  ;
        while((ipstr = reader.readLine()) != null){
            k++;
            if(k>83){
                break;
            }

            String[] str = ipstr.split("~");
            String ip = str[0];
            String mark = str[1];

            long v = getIpvalue(ip);
            long mv = getIpvalue(mark);

            if(v<legaldown || v>legalup){
                error ++;
            }else{

                if(v>=Adown && v<=Aup){
                    a++;
                }else if(v>=Bdown && v<= Bup ){
                    b++;
                }else if(v>= Cdown && v<=Cup){
                    c++;
                }else if(v>=Ddown  && v<=Dup){
                    d++;
                }else if(v>=Edown  && v<=Eup){
                    e++;
                }

                if((v>= per1down && v<=per1up) || (v>= per2down && v<=per2up) || (v>= per3down && v<=per3up)){
                    personal++;
                }
            }

            if(mv<legaldown || mv>legalup || !checkMask(mark)){
                error++;
            }

        }
        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+error+" "+personal);
    }
}

package com.binblink.leetcode.newcow;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，
 * 希望大家能正确处理)。
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * <p>
 * 当没有新的输入时，说明输入结束。
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {

            boolean[] stu = new boolean[1001];
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++)
                stu[Integer.parseInt(bf.readLine())] = true;
            for (int i = 0; i < 1001; i++)
                if (stu[i])
                    sb.append(i).append("\n");
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }

    /**
     * 百钱买鸡
     */
    @Test
    public void test() throws IOException {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bReader.readLine()) != null) {
            Integer num = Integer.parseInt(str);

            int x, y, z;
            int limit = 100 / 5;
            for (int i = 0; i <= limit; i++) {
                int t = (600 + 6 * i) % 8;
                if (t == 0) {
                    z = (600 + 6 * i) / 8;
                    x = i;
                    y = 100 - i - z;

                    if (y >= 0) {

                        System.out.println(x + " " + y + " " + z);
                    }
                }
            }

        }
    }


    @Test
    public void test2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> HMp = new HashMap<>();
        HMp.put("reset", "reset what");
        HMp.put("reset board", "board fault");
        HMp.put("board add", "where to add");
        HMp.put("board delete", "no board at all");
        HMp.put("reboot backplane", "impossible");
        HMp.put("backplane abort", "install first");

        String input = br.readLine();

        while (null != input) {
            if (HMp.containsKey(input)) {
                System.out.println(HMp.get(input));
            } else {
                System.out.println("unknown command");
            }

            input = br.readLine();
        }
    }

    @Test
    public void test4() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String error = "unknown command";
        HashMap<String, String> map = new HashMap();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");

        while ((str = reader.readLine()) != null) {
            String[] s = str.split(" ");
            int sl = s.length;

            ArrayList<String> list = new ArrayList();
            Set<Map.Entry<String, String>> set = map.entrySet();

            for (Map.Entry<String, String> entry : set) {
                String comm = entry.getKey();
                String[] commArr = comm.split(" ");
                if (sl == commArr.length) {
                    int k = 0;
                    boolean re = true;
                    for (String m : s) {
                        if (commArr[k].indexOf(m) != 0) {
                            re = false;
                            break;
                        }
                        k++;
                    }
                    if (re) {
                        list.add(entry.getValue());
                    }
                }
            }

            if (list.size() != 1) {
                System.out.println(error);
            } else {
                System.out.println(list.get(0));
            }


        }
    }

    /**
     * 密码强度
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int point = 0;
            int le = str.length();
            if (le <= 4) {
                point = point + 5;
            } else if (5 <= le && le <= 7) {
                point = point + 10;
            } else if (8 <= le) {
                point = point + 25;
            }

            int azl = 0;
            int AZl = 0;

            int digitnum = 0;
            int symbotl = 0;
            for (int i = 0; i < le; i++) {
                char c = str.charAt(i);
                if ('a' <= c && 'z' >= c) {
                    azl++;
                }

                if ('A' <= c && 'Z' >= c) {
                    AZl++;
                }

                if ('0' <= c && '9' >= c) {
                    digitnum++;
                }

                if ('!' <= c && '/' >= c) {
                    symbotl++;
                }
                if (':' <= c && '@' >= c) {
                    symbotl++;
                }

                if ('[' <= c && '`' >= c) {
                    symbotl++;
                }
                if ('{' <= c && '~' >= c) {
                    symbotl++;
                }

            }

            if ((azl > 0 && AZl == 0) || (AZl > 0 && azl == 0)) {
                point = point + 10;
            }

            if (0 < azl && azl < le && AZl > 0) {
                point = point + 20;
            }

            if (digitnum == 1) {
                point = point + 10;
            }

            if (digitnum > 1) {
                point = point + 20;
            }

            if (symbotl == 1) {
                point = point + 10;
            }

            if (symbotl > 1) {
                point = point + 25;
            }


            if (symbotl > 0 && digitnum > 0 && azl > 0 && AZl > 0) {
                point = point + 5;
            } else if (symbotl > 0 && digitnum > 0 && (azl > 0 || AZl > 0)) {
                point = point + 3;
            } else if (symbotl == 0 && digitnum > 0 && (azl > 0 || AZl > 0)) {
                point = point + 2;
            }

            System.out.println(point);
            if (point >= 90) {

                System.out.println("VERY_SECURE");
            }

            if (point < 90 && point >= 80) {
                System.out.println("SECURE");
            }

            if (point < 80 && point >= 70) {
                System.out.println("VERY_STRONG");
            }
            if (point < 70 && point >= 60) {
                System.out.println("STRONG");
            }
            if (point < 60 && point >= 50) {
                System.out.println("AVERAGE");
            }
            if (point < 50 && point >= 25) {
                System.out.println("WEAK");
            }
            if (point < 25 && point >= 00) {
                System.out.println("VERY_WEAK");
            }

        }
    }


    /**
     * ip转换
     */
    @Test
    public void test5() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String ipstr = reader.readLine();
        long ipInt = Long.parseLong(reader.readLine());

        String[] iparr = ipstr.split("\\.");

        long firstp = Long.parseLong(iparr[0]) << 24;
        long secondp = Long.parseLong(iparr[1]) << 16;
        long thirdp = Long.parseLong(iparr[2]) << 8;
        long fourp = Long.parseLong(iparr[3]);

        System.out.println(firstp + secondp + thirdp + fourp);

        firstp = ipInt >> 24;
        secondp = (ipInt << 40) >>> 56;
        thirdp = (ipInt << 48) >>> 56;
        fourp = (ipInt << 56) >>> 56;
        System.out.println(firstp + "." + secondp + "." + thirdp + "." + fourp);

    }

    @Test
    public void test9() throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = bReader.readLine()) != null) {
            System.out.println(str.substring(0, str.length()));
            char[] strArr = str.toCharArray();
            boolean[] numbexit = new boolean[10];

            for (int i = strArr.length - 1; i >= 0; i--) {
                int value = Integer.parseInt(String.valueOf(strArr[i]));
                if (!numbexit[value]) {
                    numbexit[value] = true;
                    System.out.print(strArr[i]);
                }
            }
        }
    }

    @Test
    public void test10() throws IOException {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ( null != (str = bReader.readLine()) ) {

            boolean az = false;
            boolean AZ = false;
            boolean digit = false;
            boolean others = false;

            boolean hassame = false;
            int type = 0;
            int le = str.length();

            if (le < 9) {
                System.out.println("NG");
                continue;
            }

            for (int i = 0; i < le; i++) {
                char c = str.charAt(i);

                if (i < le - 3) {
                    String sub = str.substring(i, i + 3);
                    String remaining = str.substring(i + 3, le);

                    if (remaining.contains(sub)) {
                        System.out.println("NG");
                        hassame = true;
                        break;
                    }
                }

                if (c >= 'a' && c <= 'z') {
                    az = true;
                    continue;
                }

                if (c >= 'A' && c <= 'Z') {
                    AZ = true;
                    continue;
                }

                if (c >= '0' && c <= '9') {
                    digit = true;
                    continue;
                }

                others = true;
            }

            if (az) {
                type++;
            }
            if (AZ) {
                type++;
            }
            if (digit) {
                type++;
            }
            if (others ) {
                type++;
            }

            if (type >= 3 && !hassame) {

                System.out.println("OK");
            } else {
                System.out.println("NG");
            }

        }


    }
}

package com.binblink.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubStirng {

    public int lengthOfLongestSubstring(String s) {

        String reuslt = "";
        int currentSubMaxLenght = 0;

        int slength = s.length();
        for (int i = 0; i < slength; i++) {

            if (currentSubMaxLenght >= (slength - i)) {
                break;
            }

            int endIndex = i + currentSubMaxLenght + 1;
            String sub = "";
            if (endIndex > slength) {
                sub = s.substring(i, s.length());
            } else {

                sub = s.substring(i, endIndex);
            }

            int nextIndex = endIndex;
//            sub.length() >= currentSubMaxLenght &&
            while (!isRepeatSubString(sub)) {
                reuslt = sub;
                currentSubMaxLenght = reuslt.length();
                nextIndex = nextIndex + 1;

                if (nextIndex <= slength) {
                    sub = s.substring(i, nextIndex);
                } else {
                    break;
                }
            }
        }

        System.out.println("最长子串为：" + reuslt + "-----长度为：" + currentSubMaxLenght);

        return currentSubMaxLenght;

    }

    public boolean isRepeatSubString(String sub) {

        HashSet<String> set = new HashSet<>();
        int l = sub.length();
        for (int i = 0; i < l; i++) {
            String c = sub.substring(i, i + 1);
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }

    /**
     * 最佳时间
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }



    public static void main(String[] args) {
        LongestSubStirng longestSubStirng = new LongestSubStirng();
        String s = "abcwdfwhjkliop";

        int result = longestSubStirng.lengthOfLongestSubstring3(s);

        System.out.println(result);
    }
}

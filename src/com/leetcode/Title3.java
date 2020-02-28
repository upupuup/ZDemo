package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 无重复字符的最长子串
 * @Author: jiangzhihong
 * @CreateDate: 2020/2/28 22:29
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Title3 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //每次计算都需要比较map.get(s.charAt(j))和i的大小，因为b重复了，要跳过前面的
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // 比较这一次的大还是原来的大
            ans = Math.max(ans, j-i+1);
            // 将值放入
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
}

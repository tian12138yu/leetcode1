package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/6/16 15:58
 */

import java.util.Arrays;

/**
 *
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 */
public class code242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())return false;
        int[] a =new int[26];
        int[] b =new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] += 1;
            b[t.charAt(i) - 'a'] += 1;
        }

        return Arrays.equals(a,b);
    }

}

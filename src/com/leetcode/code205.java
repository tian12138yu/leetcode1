package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/31 16:15
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 给定两个字符串 s 和 t，判断它们是否是同构的。

 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 示例 1:

 输入: s = "egg", t = "add"
 输出: true
 示例 2:

 输入: s = "foo", t = "bar"
 输出: false
 示例 3:

 输入: s = "paper", t = "title"
 输出: true
 */
public class code205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())return false;
        Map<Character, Character> map = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            if (map.containsKey(chars1[i]) && map.get(chars1[i]) != chars2[i]){
                return false;
            }else {
                map.put(chars1[i],chars2[i]);
            }
        }
        return true;
    }
}























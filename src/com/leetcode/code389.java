package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/6/1 16:44
 */

import java.util.Collections;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 */
public class code389 {

    public char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        char c = ' ';
        for (int i = 0; i < chars.length; i++) {
            c = (char) (c ^ chars[i]);
        }
        for (int i = 0; i < chars1.length; i++) {
            c = (char) (c ^ chars1[i]);
        }
        return (char)(c + 32);
    }
}
















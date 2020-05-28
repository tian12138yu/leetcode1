package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/28 19:06
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0

 */
public class code771 {

    public int numJewelsInStones(String J, String S) {
        char[] chars1 = J.toCharArray();
        char[] chars2 = S.toCharArray();
        ArrayList<Character> al = new ArrayList<>();
        for (int i = 0; i < chars1.length; i++) {
            al.add(chars1[i]);
        }
        int count = 0;
        for (int i = 0; i < chars2.length; i++) {
            if (al.contains(chars2[i])){
                count++;
            }
        }
        return count;
    }
}

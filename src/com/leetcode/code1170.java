package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/6/2 14:32
 */

import java.util.Arrays;

/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 *
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 *
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 */
public class code1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int [] w = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            w[i] = num(words[i]);
        }
        int[] r = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int res = num(queries[i]);
            int count = 0;
            for (int j = 0; j < w.length; j++) {
                if (res < w[j]){
                    count++;
                }
            }
            r[i] = count;
        }
        return r;
    }

    private int num(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i-1]){
                return count;
            }else {
                count++;
            }
        }
        return count;
    }
}

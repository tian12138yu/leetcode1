package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/3 12:54
 */


import java.util.Arrays;

/**
 *
 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

 示例 1:

 输入: S = "loveleetcode", C = 'e'
 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class code821 {
    /**
     * 快慢指针，快指针指向与C相同的字符，慢指针遍历S，计算两个指针相差的角标。
     * 存储上一个C的位置，比较离这次的C近还是上一个的C
     * @param S
     * @param C
     * @return
     */
    public static int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] a = new int[chars.length];
        boolean start = true;
        int i = 0;
        int j = 0;
        int old ;
        while (chars [j] != C){
            j++;
        }
        start = false;
        old = j;
        while (i < chars.length){
            if (start){
                start = false;

                while (j < chars.length){

                    if (chars[j] == C){
                        break;
                    }
                    j++;

                }
            }

            if (j == chars.length && chars[j - 1] != C){
                j = old;
            }

            while (i < chars.length){
                if (i == j){
                    start = true;
                    old = j;
                    j++;
                    a[i] = 0;
                }else {
                    a[i] = Math.min(Math.abs(i - old),Math.abs(j - i));
                }
                i++;
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] ints = shortestToChar("abaa", 'b');
        System.out.println(Arrays.toString(ints));
    }
}

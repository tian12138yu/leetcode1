package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/6/4 15:29
 */

import java.util.Arrays;

/**
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 *
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * 示例 2：
 *
 * 输入：[5,5,5,5]
 * 输出：""
 */
public class code949 {

    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        if (A[0] > 2)return "";

        if (A[2] == 2){
            sb.append(A[2]);
            if (A[3] == 3){
                sb.append(A[3]);
                sb.append(":");
                sb.append(A[1]);
                sb.append(A[0]);
                return sb.toString();
            }
        }
        else {
            sb.append(A[1]);
            if (A[2] == 3){
                sb.append(A[2]);
                sb.append(":");
                if (A[3] < 6){
                    sb.append(A[3]);
                    sb.append(A[0]);
                }else {
                    sb.append(A[0]);
                    sb.append(A[3]);
                }
            }
            else {
                sb.append(A[0]);
                sb.append(":");
                if (A[3] < 6){
                    sb.append(A[3]);
                    sb.append(A[2]);
                }else {
                    sb.append(A[2]);
                    sb.append(A[3]);
                }
            }
        }

        return sb.toString();
    }
}

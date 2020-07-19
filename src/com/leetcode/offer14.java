package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/7/19 17:24
 */


/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 */
public class offer14 {

    public int cuttingRope(int n) {
        if (n == 2)return 1;
        if (n == 3)return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;//当二和三的时候不需要分割，乘上本身是最大的。
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 0; j <= i / 2; j++) {
                max = Math.max(max,dp[j] * dp[i - j]);
            }
            dp [i] = max;
        }
        return dp[n];
    }
}

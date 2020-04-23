package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/23 14:46
 */


/**
 *
 输入： [2,1,4,5,3,1,1,3]
 输出： 12
 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 */
public class mianshi17_16 {
    //错误的解法，size不可控，dp方程推断错误，
    public int massage(int[] nums) {
        int size;
        if (nums.length % 2 == 0){
            size = nums.length/2;
        }else {
            size = nums.length / 2 + 1;
        }
        int[] dp = new int[size];
        int temp = Math.max(nums[0],nums[1]) == nums[0] ? 0 : 1;
        dp [0] = nums[temp];
        int x = 1;
        for (; x < size; x++ ){
            dp[x] = dp[x-1] + Math.max(nums[temp + 2] , nums[temp + 3]);
        }


        return dp[x];
    }

    public int massage1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public int massage2(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}

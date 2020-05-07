package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/7 13:24
 */


/**
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */
public class code713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for (int x = 0; x < nums.length; x++){
            if (nums[x] < k){
                count++;
            }
            sum *= nums[x];
            if (sum < k && x != 0){
                count++;
            }else {
                sum = nums[x];
            }
        }
        return count;
    }

    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        return nums(nums,k,0,0);
    }

    private static int nums(int[] nums, int k,int i,int sum){
        if (i >= nums.length)return 0;
        int x = 0;
        if (nums[i] < k)x++;
        if (nums[i] * sum < k && i > 0){
            x++;
            return nums(nums,k,i+1,sum * nums[i]) +
                    nums(nums,k,i+1,nums[i]) + x;
        }


        return nums(nums,k,i+1,nums[i]) + x;
    }

    public int numSubarrayProductLessThanK3(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] num ={10,5,2,6};
        int i = numSubarrayProductLessThanK1(num, 100);
        System.out.println(i);

    }
}

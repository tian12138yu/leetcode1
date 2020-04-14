package com.leetcode;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/4/7 14:24
 */

public class code16 {

    public static void main(String[] args) {
        int a[]={-1,2,1,-4};
        int i = threeSumClosest(a, 1);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }





}

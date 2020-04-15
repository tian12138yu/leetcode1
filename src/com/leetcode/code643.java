package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/15 14:52
 */

public class code643 {

    public static double findMaxAverage(int[] nums, int k) {
        double avg=0;double sum=0;
        for(int i = 0; i < k; i++ ){
            sum+=nums[i];
        }
        avg=sum/k;
        for(int x = k; x < nums.length; x++ ){
            sum=sum-nums[x-k]+nums[x];
            avg=Math.max(avg,sum/k);
        }
        return avg;

    }

    public static void main(String[] args) {
        int[] nums ={0,1,1,3,3};
        double maxAverage = findMaxAverage(nums, 4);
        System.out.println(maxAverage);
        System.exit(0);

    }
}

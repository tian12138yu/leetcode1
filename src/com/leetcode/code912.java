package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/30 14:30
 */


/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 */
public class code912 {
    //快排
    public int[] sortArray(int[] nums) {
        quikeSort(nums,0,nums.length-1);
        return nums;
    }

    public void quikeSort(int nums[],int i,int j){
        int base = i;
        int last = j;
        if (i >= j )return;
        int temp = nums[base];
        while (i < j){
            while (nums[j] <= temp && i < j){
                j--;
            }

            while (nums[i] >= temp && i < j){
                i++;
            }

            if (i < j){
                int x = nums[i];
                nums[i] = nums[j];
                nums[j] = x;
            }

        }

        int x = nums[base];
        nums[base] = nums[i];
        nums[i] = x;

        quikeSort(nums,base,i-1);
        quikeSort(nums,i+1,last);

    }
}

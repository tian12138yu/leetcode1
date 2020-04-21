package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/21 13:37
 */


/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */
public class mianshi57 {


    /**
     * 双指针，因为数组为有序数组，一个头一个尾，相加后大于，尾减，小于，头加。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int pre =0;int last = nums.length-1;
        int count;
        while (pre < last){
            count = nums[pre] + nums[last];
            if (count == target){
                return new int[]{nums[pre],nums[last]};
            }
            if (count < target){
                pre++;
            }else {
                last--;
            }
        }
        return new int[]{};
    }
}

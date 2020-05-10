package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/10 12:53
 */

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 *
 * 输入: [2,2,2,0,1]
 * 输出: 0
 */
public class code154 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            while (left < right && nums [left] == nums[left + 1])left++;
            while (left < right && nums [right] == nums[right + 1])right++;
            if (nums[mid] > nums[right]){
                left = mid +1;
            }else {
                right = mid;
            }

        }
        return nums[left];

    }











}















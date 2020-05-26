package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/26 13:48
 */

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class code75 {

    public void sortColors(int[] nums) {
        if (nums.length <= 0)return;

        sort(nums,0,nums.length-1);
    }

    public void sort(int[] nums,int low,int high){
        if (low >= high)return;
        int left = low;
        int right = high;
        int targt = nums[left];
        while (left < right){
            while (nums[right] > targt && left < right){
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= targt & left < right){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = targt;
        sort(nums,low,left - 1);
        sort(nums,left + 1,high);
    }


}

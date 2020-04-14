package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/9 15:15
 */


/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class code34 {

    public static void main(String[] args) {
        int[] nums={4,4};
        int []sum=searchRange(nums,4);
        for (int a:sum) {
            System.out.println(a);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int size=nums.length;
        int fir=0;
        int last=size-1;
        int mid;
        int[] x={-1,-1};
        int[] y={0,0};
        if(size==1){
            if(nums[0]!=target){
                    return x;
            } else {
                return y;
            }
        }
        while(fir<=last){
            mid=(fir+last)/2;
            if(target<nums[mid]){
                last=mid-1;
            }else if(target>nums[mid]){
                fir=mid+1;
            }else {
                return howMany(nums,mid);
            }
        }
        return x;
    }

    public static int[] howMany(int nums[],int count){
        int count1=count;
        int count2=count;
        int a=nums[count];int b=0;int c=0;
        count2--;
        count1++;
        while(count1<nums.length&&nums[count1]==a){
            b++;
            count1++;
        }
        while(count2>=0&&nums[count2]==a){
            c++;
            count2--;

        }
        int[] x={count-c,count+b};
        return x;

    }
}

package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/13 15:23
 */


/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNum {
    public static void main(String[] args) {
        int a[]={3,4,5,1,2};
        int i = minNumberInRotateArray(a);
        System.out.println(i);
    }

    public int minNumberInRotateArray1(int [] nums) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static int minNumberInRotateArray(int[] array) {
        if(array.length==0)return 0;
        if(array.length==1)return array[0];
        int fir=0;
        int last=array.length-1;int mid=0;
        while(fir<last){
            mid=(fir+last)/2;
//            if(mid!=0&&array[mid]<array[mid-1])return array[mid];
            if( array[mid] > array[fir] ){
                fir=mid+1;

            }else if(array[mid] < array[fir]){
                last=mid-1;

            }else {
                last=mid;
            }
        }
        return array[mid];

    }



}

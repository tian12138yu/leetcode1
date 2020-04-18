package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/18 15:38
 */


import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class swapSum {

    public static void main(String[] args) {
        int[] a={2,4,6,8,10,3,5,7,9};
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 使用冒泡排序把偶数都调到数组最后。
     * @param array
     */
    public static void reOrderArray(int [] array) {

        int loop = array.length;
        while (loop >= 0)
        {
            boolean change = false;
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i] % 2 == 0 && array[i + 1] % 2 == 1)
                {
                    array[i] = array[i] ^ array[i+1];
                    array[i+1] = array[i] ^ array[i+1];
                    array[i] = array[i] ^ array[i+1];
                    change = true;
                }
            }
            if (!change)
            {
                return;
            }
        }
    }

}


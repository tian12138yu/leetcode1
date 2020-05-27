package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/27 15:32
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *  
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 */
public class code658 {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        boolean isFind = false;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (arr[mid] < x) {
                left = mid;
            } else if (arr[mid] > x) {
                right = mid;
            } else {
                isFind = true;
                break;
            }
        }
        List<Integer> al = new ArrayList<>();
        if (isFind) {
            left = Math.max(0, mid - k + 1);
            right = Math.min(arr.length - 1, mid + k - 1);

        } else {
            right = Math.min(arr.length - 1, left + k - 1);
            left = Math.max(0, left - k + 1);

        }
        while (right - left > k - 1) {
            if (x - arr[left] > arr[right] - x) {
                left++;

            } else
                right--;
        }

        for (int i = 0; i < k; i++) {
            al.add(arr[left]);
            left++;
        }
        return al;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = ret.size();
        if (x <= ret.get(0)) {
            return ret.subList(0, k);
        } else if (ret.get(n - 1) <= x) {
            return ret.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(ret, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(ret.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x))
                    high--;
                else if ((x - ret.get(low)) > (ret.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return ret.subList(low, high + 1);
        }
    }


    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        int x =4;
        int y= 3;
        List<Integer> closestElements = findClosestElements(a, x, y);
        System.out.println(closestElements);
    }
}

package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/6/15 14:46
 */

import java.util.*;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class code239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)return new int[0];
        Deque<Integer> deque = new LinkedList();
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.getFirst() == i-k){
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.offer(i);
            if (i >= k-1){
                al.add(deque.getFirst());
            }

        }

        int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = nums[al.get(i)];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a ={9,11};
        int[] ints = maxSlidingWindow(a, 2);
        System.out.println(Arrays.toString(ints));
    }
}



















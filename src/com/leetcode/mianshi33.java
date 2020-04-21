package com.leetcode;

import java.util.Stack;

/**
 * @Author tjy
 * @Date 2020/4/16 16:50
 */

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class mianshi33 {
    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a={1,3,2,5,7,6,4};
        boolean b = verifyPostorder(a);
        System.out.println(b);
    }
}

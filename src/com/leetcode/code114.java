package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/17 14:06
 */

/**
 * 给定一个二叉树，原地将它展开为链表。
 */
public class code114 {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}

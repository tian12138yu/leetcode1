package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/17 13:18
 */

import javafx.util.BuilderFactory;

/**
 *
 实现一个函数，检查一棵二叉树是否为二叉搜索树。

 示例 1:
 输入:
 2
 / \
 1   3
 输出: true
 */
public class MianShi04_05 {

    public static boolean isValidBST(TreeNode root) {
        if (root == null)return true;
        return dfs(root);
    }

    static long pre = Long.MIN_VALUE;
    private static boolean dfs(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left= dfs(root.left);
        if (root.val < pre)return false;
        pre = root.val;
        boolean right = dfs(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode1.left = treeNode2;
        System.out.println(isValidBST(treeNode1));
    }

}

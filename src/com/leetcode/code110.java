package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/16 16:41
 */

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 */
public class code110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        return isTree(root) >= 0;
    }

    private int isTree(TreeNode root) {
        if (root == null)return 0;
        int lh = isTree(root.left), rh = isTree(root.right);
        if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }
}

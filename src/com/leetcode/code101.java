package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/16 16:57
 */

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class code101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return isSame(root.left,root.right);
    }

    public boolean isSame(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 == null)return true;
        if (root1 == null || root2 == null)return false;
        if (root1.val != root2.val)return false;
        return isSame(root1.left,root2.right) && isSame(root1.right,root2.left);
    }
}

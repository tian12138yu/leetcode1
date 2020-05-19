package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/19 16:34
 */

public class code100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)return true;
        if (p == null || q == null)return false;
        if (p.val != q.val)return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}

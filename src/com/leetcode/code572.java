package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/16 14:01
 */

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 */
public class code572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)return true;
        if (s == null || t == null)return false;
        if (s.val == t.val){
            return isSubtree(s.left,t.left) && isSubtree(s.right,t.right);
        }

        return isSubtree(s.left,t.left) || isSubtree(s.right,t.right);


    }

    /**
     * 两个函数： 一个为递归遍历函数，将子树和要判断树进行判断
     *           一个为判断当前两颗树是否相等。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if (s == null) return false;
//t是s的子树，要么t等于s，要么t等于s的左/右子树。
        return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean subFrom(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }
}

package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/23 16:02
 */


/**
 *输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class TheSonOfTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        return  sameTree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean sameTree(TreeNode root1,TreeNode root2){
        if (root2 == null)return true;
        if (root1 == null )return false;
        if (root1.val != root2.val)return false;

        return sameTree(root1.left , root2.left) && sameTree(root1.right , root2.right);
    }
}

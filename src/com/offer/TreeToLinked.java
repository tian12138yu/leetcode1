package com.offer;

/**
 * @Author tjy
 * @Date 2020/5/19 14:23
 */

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TreeToLinked {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode root;
    TreeNode pre;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)return null;
        Convert(pRootOfTree.left);
        if (root == null){
            root = pRootOfTree;
        }
        pRootOfTree.left = pre;
        if (pre != null){
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);

        return root;
    }

    /**
     * 反向进行遍历，可以不用记录第一个节点
     */
    TreeNode pre1 = null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        Convert(pRootOfTree.right);
        if (pre!= null){
            pRootOfTree.right=pre;
            pre.left=pRootOfTree;
        }
        pre=pRootOfTree;
        Convert(pRootOfTree.left);
        return pre;
    }
}

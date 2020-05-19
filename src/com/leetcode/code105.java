package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/19 15:53
 */


import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class code105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)return null;
        int x = 0;
        while (preorder[0] != inorder[x]){
            x++;
        }
        int[] left = new int[x];
        int[] right = new int[inorder.length - x - 1];
        System.arraycopy(preorder,1,left,0,left.length);
        System.arraycopy(preorder,x+1,right,0,right.length);
        TreeNode root = new TreeNode(preorder[0]);
        root.left = bt(left);
        index = 0;
        root.right = bt(right);
        return root;
    }
    int index = 0;
    private TreeNode bt(int[] array) {
        if (index >= array.length)return null;
        TreeNode treeNode = new TreeNode(array[index]);
        index++;
        treeNode.left = bt(array);
        treeNode.right = bt(array);
        return treeNode;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //递归的第一步：递归终止条件，避免死循环
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        //重建根节点
        TreeNode treeNode = new TreeNode(preorder[pStart]);
        int index = 0;  //index找到根节点在中序遍历的位置
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        //重建左子树
        treeNode.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        //重建右子树
        treeNode.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return treeNode;

    }


}

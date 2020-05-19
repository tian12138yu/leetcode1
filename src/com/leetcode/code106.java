package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/19 20:07
 */

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class code106 {
    public  int postIndex;
    public TreeNode buildTreeChild(int[] inorder, int[] postorder,int inbegin,int inend) {
        if (inbegin > inend)return null;
        TreeNode treeNode = new TreeNode(postorder[postIndex]);
        int x = 0;
        while (inorder[x] != postorder[postIndex]){
            x++;
        }


        return null;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        if(inorder == null || postorder == null) return null;
        if(inorder.length <= 0 || postorder.length <= 0) return null;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
}

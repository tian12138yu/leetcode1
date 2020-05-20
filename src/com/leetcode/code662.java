package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/20 12:46
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 */
public class code662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)return 0;
        bfs(root,0);
        return 0;
    }

    private void bfs(TreeNode root, int i) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
    }

    private int maxW = 0;

    public int widthOfBinaryTree1(TreeNode root) {
        /**
         假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
         用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
         节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
         加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
         **/
        dfs(root, 1, 1, new ArrayList<>());
        return maxW;
    }

    private void dfs(TreeNode r, int level, int index, List<Integer> left) {
        if(r == null) return;
        if(level > left.size()) left.add(index);
        maxW = Math.max(maxW, index - left.get(level-1) + 1);
        dfs(r.left, level+1, index*2, left);
        dfs(r.right, level+1, index*2+1, left);
    }
}












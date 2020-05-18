package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/18 15:05
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class code515 {
    private List<Integer> al = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)return al;
        bfs(root,1);
        return al;
    }

    private void bfs(TreeNode root,int level){
        if (root == null)return;
        if (al.size() < level)al.add(root.val);
        if (al.get(level - 1) < root.val)al.set(level - 1 ,root.val);
        bfs(root.left,level + 1);
        bfs(root.right,level + 1);
    }

}

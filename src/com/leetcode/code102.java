package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/4 13:33
 */

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class code102 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 广度优先搜索
     * 维护一个队列，每次放入当前节点的左右孩子，在取出队列第一个元素，直至取完。
     * 无法判断是否为同一层
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode father = new TreeNode(Integer.MAX_VALUE);
        Map<TreeNode,TreeNode> map = new HashMap<>();
        List<List<Integer>> als = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root,father);
        List<Integer> al = new ArrayList<>();
        queue.offer(root);
        TreeNode node ;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node == null)continue;

            if (map.get(node) == father){
                al.add(node.val);
                als.add(al);
            }else {
                father = map.get(node);
                al = new ArrayList<>();
                al.add(node.val);
                if (!als.contains(al)){
                    als.add(al);
                }

            }
            queue.add(node.left);
            queue.add(node.right);
            map.put(node.left,node);
            map.put(node.right,node);

        }
        return als;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
        List<List<Integer>> lists = levelOrder(node);
        for (int i = 0; i < lists.size(); i++){
            List<Integer> list = lists.get(i);
            System.out.print("[");
            for (int j = 0; j < list.size(); j++){
                System.out.print(list.get(j));
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }


    /**
     * dfs,在添加的时候判断是否为当前层第一个节点，是则新建一个数组，
     * 否则则获取到当前层级的数组，将当前节点装入。（因为是dfs所以每一层的数组都会在遍历左子树时创建，
     * 遍历右子树只需获取到前面创建的，将节点装入就行了）
     *
     */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }


}



















package com.offer;

/**
 * @Author tjy
 * @Date 2020/5/25 15:57
 */

import com.leetcode.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathOfTree {
    ArrayList als = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> al = new ArrayList<>();
        int count = 0;
        bfs(root,target,al,count);
        return als;
    }

    private void bfs(TreeNode root, int target, ArrayList<Integer> al,int count) {
        if (root == null)return;
        if (count + root.val == target &&
                root.left==null && root.right==null){
            al.add(root.val);
            als.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
        }

        al.add(root.val);
        bfs(root.left,target,al,count + root.val);
        bfs(root.right,target,al,count + root.val);
        al.remove(al.size()-1);

    }

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return arr;
        ArrayList<Integer> a1=new ArrayList<Integer>();
        int sum=0;
        pa(root,target,arr,a1,sum);
        return arr;
    }
    public void pa(TreeNode root,int target,ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1,int sum){
        if(root==null)
            return ;
        sum+=root.val;

        if(root.left==null&&root.right==null){
            if(sum==target)
            { a1.add(root.val);
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size()-1);

            }
            return ;

        }

        a1.add(root.val);
        pa(root.left,target,arr,a1,sum);
        pa(root.right,target,arr,a1,sum);
        a1.remove(a1.size()-1);
    }


}

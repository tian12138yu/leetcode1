package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/13 13:30
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 * 示例 1：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 */
public class coed1260 {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> als  = swap(grid);
        if (k == 0)return als;
        while (k > 0){
            als = swap(als);
            k--;
        }
        return als;
    }

    private static List<List<Integer>> swap(int[][] grid){
        List<List<Integer>> als = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            als.add(new ArrayList<>());
            for (int j = 0; j < grid[0].length; j++) {
                als.get(i).add(grid[i][j]);
            }

        }
        return als;
    }

    private static List<List<Integer>> swap(List<List<Integer>> als){
        List<List<Integer>> als1 = new ArrayList<>();
        int len = als.size();
        int len1 = als.get(0).size();
        als1.add(new ArrayList<>());
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len1; j++) {
                if (j == len1 - 1 && i != len-1){
                    als1.add(new ArrayList<>());
                    als1.get(i + 1).add(0,als.get(i).get(j));
                }
                else if (i == len-1 && j == len1-1){
                    als1.get(0).add(0,als.get(i).get(j));
                }
                else {
                    als1.get(i).add(als.get(i).get(j));
                }
            }

        }
        return als1;
    }

    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int[] nums = new int[grid.length * grid[0].length];
        for(int i = 0, iMax = grid.length;i < iMax;i++) {
            for(int j = 0, jMax = grid[0].length;j < jMax;j++) {
                k %= nums.length;
                nums[k++] = grid[i][j];
            }
        }
        k = 0;
        List<List<Integer>> lists = new ArrayList<>(grid.length);
        for(int i = 0, iMax = grid.length;i < iMax;i++) {
            List<Integer> tempList = new ArrayList<>(grid[0].length);
            for(int j = 0, jMax = grid[0].length;j < jMax;j++) {
                tempList.add(nums[k++]);
            }
            lists.add(tempList);
        }
        return lists;
    }

    public static void main(String[] args) {
        int[][] a =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> lists = shiftGrid(a, 1);
        System.out.println(lists);
    }

}

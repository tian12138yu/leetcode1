package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/2 14:12
 */


/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。

 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 */
public class code1277 {
    /**
     * 空间复杂度：O(1)
     * 时间复杂度：O(N)
     * 此处matrix[i][j]记录的是：
     * 以此点为右下角的正方形的个数
     * 关键状态转移方程：
     * matrix[i][j] = min(matrix[i - 1][j - 1],min(matrix[i - 1][j],matrix[i][j - 1])) + 1;
     * 由左上角往右下角遍历，前者状态不再改变，故可以直接记录在原矩阵上
     * 以大小为二的正方形举例：
     * 如果存在，则左上方，上方，左方均存在大小为一的全1正方形
     * 以大小为三的正方形举例：
     * 如果存在，则左上角，上方，左方均存在大小为二的全1正方形
     * 由此动态规划得出结论
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int ans = 0;
        for(int i = 0 ; i < matrix.length ; i++)
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0) continue;
                else if(i == 0 || j == 0) ans++;
                else{
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1],Math.min(matrix[i - 1][j],matrix[i][j - 1])) + 1;
                    ans += matrix[i][j];
                }
            }
        return ans;
    }
}

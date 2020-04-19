package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/19 14:17
 */


/**
 * 一个小人从起点到终点有多少种走法。图中有石头，则不可通过。
 */
public class manTo {

    public static int digui(int[][] tu,int i,int j){
        if (tu[i][j]==1)return 1;
        if (tu[i][j]==0)return 0;
        return digui(tu,i,j-1)+digui(tu,i-1,j);
    }

    public static int dongtai(int[][] tu,int i,int j){
        int[][] res={{0}};
        int x = 0;
        int y = 0;
        for (; x < tu.length; x++){
            for (; y < tu[0].length; y++){
                if (tu[x][y] == 1){
                    res[x][y] = res[x-1][y] + res[x][y-1];
                }else return 0;
            }
        }

        return res[x][y];
    }





}

package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/30 15:04
 */


/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;

/**
 *   1  2  3  4
 *   5  6  7  8
 *   9 10 11 12
 *  13 14 15 16
 */

/** 0 5 0 3  1 4  1 2
 * [ 1, 2, 3, 4, 5]
 * [ 6, 7, 8, 9, 10]
 * [11,12,13,14,15]
 */
public class shunshizhenJuzhen {
    static ArrayList al = new ArrayList();
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix.length == 0)return null;
        if (matrix.length ==1){
            for (int i = 0 ; i < matrix[0].length; i++){
                al.add(matrix[0][i]);

            }
            return al;
        }
        if (matrix[0].length ==1){
            for (int i = 0 ; i < matrix.length; i++){
                al.add(matrix[i][0]);

            }
            return al;
        }

        printCeng(matrix,0,matrix[0].length,0,matrix.length);
        return al;
    }

    /**
     *
     * @param matrix
     * @param x 第一列
     * @param y 最后一列
     * @param z 第一行
     * @param a 最后一行
     */
    public static void printCeng(int [][] matrix, int x, int y, int z, int a){
        //1  4  1  2
        if (x >= y || z >= a)return;
        //第一行
        for (int i = x; i < y; i++){
            al.add(matrix[z][i]);
        }
        //后一列
        for (int i = z+1; i < a; i++){
            al.add(matrix[i][y-1]);
        }
        //最后一行
        for (int i = y - 2; i >= x; i--){
            if (a-1 != z){
                al.add(matrix[a-1][i]);
            }

        }
        //第一列
        for (int i = a - 2; i > z; i--){
            if (x != y-1){
                al.add(matrix[i][x]);
            }

        }
        printCeng(matrix,x+1,y-1,z+1,a-1);
    }
    //{{1,2, 3, 4},{ 5, 6, 7, 8},{ 9, 10, 11, 12},{ 13, 14, 15, 16}}
    public static void main(String[] args) {
        int [][] a ={{1},{2},{3},{4},{5}} ;
        ArrayList<Integer> integers = printMatrix(a);
        for (int i = 0; i < integers.size(); i++){
            System.out.println(integers.get(i));
        }

    }
}

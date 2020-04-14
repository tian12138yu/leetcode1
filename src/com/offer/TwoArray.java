package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/8 15:39
 */


/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class TwoArray {

//    public boolean Find(int target, int [][] array) {
////        for(int i=0;i<array.length;i++){
////            for (int j=0;j<array[0].length;j++){
////                if(array[i][j]==target)
////                    return true;
////            }
////        }
////        return false;
//        for (int i=0;i<array.length;i++){
//            if(array[i][0]<target){
//                if(i<0)return false;
//                else continue;;
//            }
//            else if(array[i][0]>target){
//                return equals(i-1,array,target);
//            }
//        }
//        return false;
//
//    }
    //左下角为当前行最小值，列最大值，判断跟target的关系，大了往上走，小了往右走
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        if(cols == 0){
            return false;
        }
        // 左下
        int row = rows-1;
        int col = 0;
        while(row>=0 && col<cols){
            if(array[row][col] < target){
                col++;
            }else if(array[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }

//    private boolean equals(int i, int[][] array, int target) {
//        for(int x=0;x<array[0].length;x++){
//            if(array[i][x]==target){
//                return true;
//            }
//        }
//        return false;
//    }

}

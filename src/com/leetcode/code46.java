package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/11 15:48
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class code46 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        List<List<Integer>> permute = new a().permute(nums);
        System.out.println(permute);
    }


}
class a{
    List<List<Integer>> alAll=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> al=new ArrayList<>();
        for (int a:nums) {
            al.add(a);
        }
        pre(al,0);

        return alAll;
    }

    private  void pre(List<Integer> list,int x){
        alAll.add(list);
        if(x==list.size()-1)return;
        for(int i = x+1;i < list.size();i++){
            List<Integer> al=new ArrayList<>(list);
            Collections.swap(al,x,i);
//            System.out.println(al);
            pre(al,x+1);
        }
        for(int j = x+2;j < list.size(); j++){
            List<Integer> al=new ArrayList<>(list);
            Collections.swap(al,x+1,j);
//            System.out.println(al);
            pre(al,x+2);
        }
    }

}

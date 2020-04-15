package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/15 15:37
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */

public class code451 {


    class Solution {
        public String frequencySort(String s) {
            //初始化字母数组
            int[] latters = new int[256];
            //填充数组
            for(char c:s.toCharArray()){
                latters[c]++;
            }
            //排序
            PriorityQueue<Latter> queue = new PriorityQueue<>();

            for (int i = 0;i<latters.length;i++){
                if (latters[i]!=0){
                    queue.add(new Latter((char) i,latters[i]));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();

            while (!queue.isEmpty()){
                Latter latter = queue.poll();
                for (int i =0;i<latter.count;i++)
                    stringBuilder.append(latter.latter);
            }


            return stringBuilder.toString();
        }

        public class Latter implements Comparable<Latter>{
            public char latter = '0';
            public int count = 0;

            public Latter(char latter, int count) {
                this.latter = latter;
                this.count = count;
            }

            @Override
            public int compareTo(Latter o) {
                return o.count - this.count;
            }
        }
    }


    public static void main(String[] args) {

    }
}

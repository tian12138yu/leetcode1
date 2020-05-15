package com.offer;

/**
 * @Author tjy
 * @Date 2020/5/15 15:45
 */

import java.util.*;

/**
 *有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
 * 第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
 *
 *给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
 * 若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
 * 若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，
 * 若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 *
 * 测试样例：
 * [[1,1],[1,-1],[2,0],[2,-1]]
 * 返回：[1,-1]
 */
public class Animal {

    private static Deque<Integer> queue =new LinkedList<>();
    private static Stack<Integer> stack = new Stack();
    private static ArrayList<Integer> al = new ArrayList<>();

    public static ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        for (int i = 0; i < ope.length; i++) {
                if (ope[i][0] == 1)
                    insert(ope[i][1]);
                else if (ope[i][0] == 2)
                    get(ope[i][1]);
        }

        return al;
    }

    private static void get(int i) {
        if (queue.isEmpty())return;
        if (i == 0){
            al.add(queue.poll());
            return;
        }

        if (i  == 1){
            while (queue.peek() < 0){
                stack.push(queue.poll());
            }
        }
        if (i == -1){
            while (queue.peek() > 0){
                stack.push(queue.poll());
            }
        }


        if (queue.isEmpty()){
            push();
            return;
        }

        al.add(queue.poll());
        push();
    }

    private static void push() {
        while (!stack.isEmpty()){
            queue.addFirst(stack.pop());
        }
    }


    private static void insert(int i) {
        queue.addLast(i);
    }

    public static void main(String[] args) {
        int[][] a ={{1,-3},{1,-6},{1,10},{1,3},{2,0},{1,19},{2,-1},{1,-81},{1,36},{2,0},{2,1}};
        ArrayList<Integer> asylum = asylum(a);
        System.out.println(asylum);
    }
}




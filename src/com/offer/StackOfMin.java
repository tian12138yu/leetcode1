package com.offer;

/**
 * @Author tjy
 * @Date 2020/5/5 14:07
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class StackOfMin {
    List<Integer> list;
    public StackOfMin(){
        list = new ArrayList<>();
    }
    public void push(int node) {
        list.add(node);
    }

    public void pop() {
        if (list.size() == 0)return;
        list.remove(list.size()-1);
    }

    public int top() {
        if (list.size() == 0)throw new RuntimeException("栈当前为空，top为空！");
        return list.get(list.size()-1);
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < list.size(); x++){
            min = Math.min(min,list.get(x));
        }
        return min;
    }
}

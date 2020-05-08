package com.offer;

/**
 * @Author tjy
 * @Date 2020/5/8 15:19
 */


import java.util.Arrays;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class StackPushList {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 && popA.length == 0)return true;
        if (pushA.length == 0 || popA.length == 0)return false;
        int pushNext = 0;
        int popNext = 0;
        int len = popA.length;
        int i = Arrays.binarySearch(pushA, popA[0]);
        if (i == len - 1){
            popNext = i - 1;
            pushNext = -1;
        }
        else if (i == 0){
            pushNext = i +1;
            popNext = len;
        }else {
            pushNext = i + 1;
            popNext = i - 1;
        }
        for (int x = 1; x < len - 1; x++){
            if (pushNext != len && popA[x] == pushA[pushNext]){
                pushNext += 1;
            }
            else if (popNext != -1 && popA[x] == pushA[popNext]){
                popNext -= 1;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean IsPopOrder1(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int x = 0;
        for (int i = 0 ; i< pushA.length; i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[x]){
                stack.pop();
                x++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        boolean b1 = IsPopOrder1(a, b);
        System.out.println(b1);
    }
}

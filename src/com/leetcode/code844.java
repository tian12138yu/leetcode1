package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/14 16:05
 */

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 */
public class code844 {

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#'){
                if (stack1.isEmpty())continue;
                stack1.pop();
            }else {
                stack1.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#'){
                if (stack2.isEmpty())continue;
                stack2.pop();
            }else {
                stack2.push(T.charAt(i));
            }
        }

        if (stack1.isEmpty() && stack1.isEmpty())return true;
        if (stack1.size() != stack2.size())return false;
        while (stack1.isEmpty()){
            if (stack1.pop() != stack2.pop())return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1="abcd";
        String s2 = "bbcd";
        System.out.println(backspaceCompare(s1, s2));
    }
}

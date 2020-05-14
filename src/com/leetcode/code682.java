package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/14 15:05
 */

import java.util.Stack;

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 示例 1:
 *
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 */
public class code682 {

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int x = 0;int count = 0;
        while (x < ops.length){
            char c = ops[x].charAt(0);
            if (c < 58 && c >47){
                count += c - 48;
                stack.push(c-48);
            }

            if (c == 45){
                c = ops[x].charAt(1);
                count -= c - 48;
                stack.push(-(c-48));
                continue;
            }

            if (c == 67){
                Integer pop = stack.pop();
                count -= pop;
            }

            if (c == 68){
                Integer pop = stack.pop();
                stack.push(pop);
                stack.push(pop * 2);
                count += pop*2;
            }

            if (c == 43){
                int one,two;
                one = stack.pop();
                two = stack.peek();
                count += one + two;
                stack.push(one);
            }
            x++;
        }
        return count;
    }


        public int calPoints1(String[] ops) {
            int[] arr = new int[ops.length];
            int i=0;
            for(String s:ops){
                switch (s){
                    case "+":arr[i]=arr[i-1]+arr[i-2];i++;break;
                    case "D":arr[i]=2*arr[i-1];i++;break;
                    case "C":arr[i-1]=0;i--;break;
                    default:
                        arr[i]=Integer.valueOf(s);
                        i++;
                }
            }
            int sum=0;
            for (int j = 0; j <arr.length ; j++) {
                sum+=arr[j];
            }
            return sum;
        }


    public static void main(String[] args) {
        String[] s ={"5","2","C","D","+"};
        System.out.println(calPoints(s));
    }
}

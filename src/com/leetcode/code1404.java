package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/6 14:20
 */


import java.math.BigInteger;
import java.util.Arrays;

/**
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 *
 * 如果当前数字为偶数，则将其除以 2 。
 *
 * 如果当前数字为奇数，则将其加上 1 。
 *
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14 
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4 
 * Step 5) 4  是偶数，除 2 得到 2 
 * Step 6) 2  是偶数，除 2 得到 1 
 */
public class code1404 {
    /**
     * 8 : 1000   4 : 0100 右移一位
     * @param s
     * @return
     */
    public int numSteps(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int len = chars.length;
        while (len != 1){
            int last = chars[chars.length - 1];
            if (last == 0){
                System.arraycopy(chars,0,chars,0,chars.length-1);
            }else {
                last = '1';
            }
            count++;
        }
        return count;
    }
    public int numSteps1(String s) {
        BigInteger bigInteger = new BigInteger(s, 10);
        return 0;
    }

//    private int num(BigInteger x){
//        int count = 0;
//        while (x .equals(1) ){
//            if ((x & 1) == 0){
//                x = x >> 1;
//            }else {
//                x = x + 1;
//            }
//            count++;
//        }
//        return count;
//    }

    public int numSteps2(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        int carry = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(i == 0 && carry == 0) break;
            if(s.charAt(i) - '0' != carry){
                carry = 1;
                ans += 1;
            }
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1101",2));
    }
}

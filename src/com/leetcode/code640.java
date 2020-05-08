package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/8 14:28
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回“No solution”。
 *
 * 如果方程有无限解，则返回“Infinite solutions”。
 *
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 *
 * 示例 1：
 *
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: "x=x"
 * 输出: "Infinite solutions"
 */
public class code640 {

    public static String solveEquation(String equation) {
        int xNum = 0;
        int constant = 0;
        String[] split = equation.split("=");
        char[] chars1 = split[0].toCharArray();
        char[] chars2 = split[1].toCharArray();
        for (int i = split[0].length()-1; i >= 0 ; i--){
            if (chars1[i] == 'x'){
                if (chars1[i-1] == 43){
                    xNum++;
                }else if (chars1[i-1] == 45){
                    xNum--;
                }
                else {
                    xNum += chars1[i - 1] - 30;
                    i--;
                }
            }
            else if (chars1[i] < 58 && chars1[i] > 47){

            }
        }
        System.out.println(Arrays.toString(split));
        return null;

    }

    public static void main(String[] args) {
        String s = "x+5-3+x=6+x-2";
        solveEquation(s);
        char c = 45;
        System.out.println(c);
    }

    public String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')
            return x.replace("x", "");
        return x.replace("x", "1");
    }
    public String solveEquation1(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x: breakIt(lr[0])) {
            if (x.indexOf("x") >= 0) {
                lhs += Integer.parseInt(coeff(x));
            } else
                rhs -= Integer.parseInt(x);
        }
        for (String x: breakIt(lr[1])) {
            if (x.indexOf("x") >= 0)
                lhs -= Integer.parseInt(coeff(x));
            else
                rhs += Integer.parseInt(x);
        }
        if (lhs == 0) {
            if (rhs == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x=" + rhs / lhs;
    }
    public List < String > breakIt(String s) {
        List< String > res = new ArrayList< >();
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0)
                    res.add(r);
                r = "" + s.charAt(i);
            } else
                r += s.charAt(i);
        }
        res.add(r);
        return res;
    }



}

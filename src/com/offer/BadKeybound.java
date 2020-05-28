package com.offer;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/28 19:27
 */

public class BadKeybound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();//7_This_is_a_test
        String actual = scanner.nextLine();//_hs_s_a_es

        //1、把实际的字符转换为大写存放到集合当中
        HashSet<Character> setActual = new HashSet<>();
        for (char s : actual.toUpperCase().toCharArray()) {
            setActual.add(s);
        }
        String s = expected.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (setActual.add(c)){
                System.out.print(c);
            }
        }

    }
}

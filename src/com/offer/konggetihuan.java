package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/9 16:36
 */


/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class konggetihuan {
    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        String replace = s.replace(" ", "%20");
        return replace;
    }
//    public static String replaceSpace(StringBuffer str) {
//
//        return str.toString().replace(" ", "%20");
//    }

    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("We Are Happy");
        String s = replaceSpace(sb);
        System.out.println(s);
    }
}

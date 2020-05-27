package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/27 13:48
 */

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。
 * 其第三级和第四级修订号均为 0。
 *  
 *
 *
 * 示例 1:
 *
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 *
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 *
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 */
public class code165 {

    public static int compareVersion(String version1, String version2) {
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        int i = 0;
        int j = 0;
        int count1 = 0,count2 = 0;
        while (i < chars1.length && j <chars2.length){
            while (i < chars1.length && chars1[i] == '0' && chars1[i] != '.'){
                count1 += chars1[i] - 48;
                i++;
            }
            while (j < chars2.length && chars2[j] == '0' && chars2[j] != '.' ){
                count2 += chars2[j] - 48;
                j++;
            }
            if (count1 < count2)return -1;
            if (count1 > count2)return 1;
            int x = 0,y = 0;
            while (j < chars2.length && chars2[j] != '.' ) {
                x++;
                j++;
            }
            while (i < chars1.length  && chars1[i] != '.'){
                y++;
                i++;
            }
            if (x < y)return 1;
            if (x > y)return -1;
            count1 = 0;
            count2 = 0;
            i++;
            j++;
        }
        while (i < chars1.length){
            count1 += chars1[i] - 48;
            i++;
        }
        if (count1 != 0)return 1;
        while (j <chars2.length){
            count2 += chars2[j] - 48;
            j++;
        }
        if (count2 != 0)return -1;
        return 0;
    }

    public int compareVersion1(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1";
        System.out.println(compareVersion(version1, version2));
    }
}

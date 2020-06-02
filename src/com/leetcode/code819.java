package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/6/2 15:07
 */

import java.util.*;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 *  
 *
 * 示例：
 *
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 */
public class code819 {
    /**
     *Character.isLetter(c)判断是否为字母。
     */

    public String mostCommonWord(String paragraph, String[] banned) {

        String s = paragraph.toLowerCase().replace(".", "");
        String[] split = s.split(",");
        if (split.length == 1)return s;
        HashMap<String, Integer> map = new HashMap<>();
        List<String> strings = Arrays.asList(banned);
        int max = 0;
        String res = null;
        for (int i = 0; i < split.length; i++) {
            String[] s1 = split[i].split(" ");
            for (int j = 0; j < s1.length; j++) {
                if (strings.contains(s1[j]))continue;
                if (map.containsKey(s1[j])){
                    int x = map.get(s1[j]);
                    map.put(s1[j],x +1);
                    if (x+1 > max){
                        max = x+1;
                        res = s1[j];
                    }
                }else {
                    map.put(s1[j],1);
                }
            }
        }
        return res;
    }

    public String mostCommonWord1(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

}

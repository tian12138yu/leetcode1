package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/31 16:46
 */

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class code350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])){
                map1.put(nums1[i],map1.get(nums1[i]) + 1);
            }else {
                map1.put(nums1[i],0);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])){
                map2.put(nums2[i],map2.get(nums2[i]) + 1);
            }else {
                map2.put(nums2[i],0);
            }
        }

        List<Integer> al = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            Integer mapKey = entry.getKey();
            if (map2.containsKey(mapKey) && map2.get(mapKey).equals(entry.getValue())){
                al.add(mapKey);
            }

        }
        int[] ress = new int[al.size()];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = al.get(i);
        }
        return ress;
    }

    public int[] intersect_3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 将 nums1 出现的数值及频次放入映射中
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++count);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map.put(num, --count);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}












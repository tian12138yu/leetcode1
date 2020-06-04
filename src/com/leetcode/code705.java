package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/6/2 16:04
 */

public class code705 {
    /** Initialize your data structure here. */
    boolean[] map = new boolean[1000005];
    public void MyHashSet() {

    }

    public void add(int key) {
        map[key] = true;
    }

    public void remove(int key) {
        map[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map[key] == true;
    }
}

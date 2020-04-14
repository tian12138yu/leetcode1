package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/10 15:36
 */

import com.leetcode.code23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class LinkToArray {
    public static ArrayList<Integer> printListFromTailToHead(code23.ListNode listNode) {
        ArrayList<Integer> al=new ArrayList<>();
        while(listNode!=null){
            al.add(listNode.val);
            listNode=listNode.next;
        }
        Collections.reverse(al);

        return al;
    }

    public static void main(String[] args) {
        code23.ListNode root1=new code23.ListNode(1);
        root1.next=new code23.ListNode(4);
        root1.next.next=new code23.ListNode(5);
        root1.next.next.next=null;
        ArrayList<Integer> integers = printListFromTailToHead(root1);
        System.out.println(integers);
    }
}

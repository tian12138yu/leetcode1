package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/21 13:57
 */


import com.leetcode.code23;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseLink {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //1->2->3->4
    static ListNode root;
    public static ListNode ReverseList(ListNode head) {
        ListNode reverse = reverse(head);
        reverse.next = null;
        return root;
    }

    public static ListNode reverse(ListNode head){
        if (head.next == null){
            root = head;
            return head;
        }
        ListNode listNode = reverse(head.next);
        listNode.next = head;

        return head;
    }

    public static void main(String[] args) {
        ListNode root1=new ListNode(1);
        root1.next=new ListNode(4);
        root1.next.next=new ListNode(5);
        root1.next.next.next=null;
        ListNode listNode = ReverseList(root1);
        while (listNode != null){
            System.out.print(listNode.val+ "->");
            listNode = listNode.next;
        }
        System.out.println("null");
    }
}

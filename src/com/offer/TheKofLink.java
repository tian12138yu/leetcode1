package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/20 14:24
 */


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *遍历全部节点，计算出K节点的位置，在遍历一次输出K节点
 *
 * 前后指针相差K就可以，当后指针到达最后时，前指针到倒数K。
 */
public class TheKofLink {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail1(ListNode head,int k) {
        ListNode last = head;
        int x = 1;
        while(last != null && last.next != null){
            last=last.next.next;
            x++;
        }
        int y;
        if (last == null){//当前的last为最后一个节点的next，求出倒数第K个节点的值。
            y=x*2-2-(k-1);
        }else {
            y = x*2-1-(k-1);
        }

        if (y <= 0)return null;

        for (int i = 0; i < y; i++){
            head = head.next;
        }

        return head;

    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode last = head;
        for (int i = 0; i < k; i++){
            if (last == null)return null;
            last=last.next;
        }

        while(last != null){
            pre = pre.next;
            last = last.next;
        }

        return pre;

    }
}

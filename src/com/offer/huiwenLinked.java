package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/26 12:13
 */


/**
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 */
public class huiwenLinked {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean chkPalindrome(ListNode A) {
        // write code here
        if (A == null)return true;
        ListNode cur = A;
        boolean b = false;
        while (cur != null){
            if (cur == cur.next){
                cur = cur.next;
                b = true;
                break;
            }
            cur = cur.next;
        }

        if (!b){
            return false;
        }

        while (cur != null){
            if (A.val != cur.val){
                b = false;
                return false;
            }
        }

        return b;

    }

    /**
     * 先找到链表的中间节点，在将后半段链表翻转，然后从头和翻转后的链表进行一一比较，不同返回false，都相同返回true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}

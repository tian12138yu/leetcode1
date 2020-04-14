package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/14 13:28
 */

/**
 *
 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。

 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 示例：

 给你这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5
 */


public class code25 {

    public static class ListNode {
     int val;
      ListNode next;
     ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode root=head;ListNode last;ListNode lHead=null;
        boolean a=true;
        out:while (head!=null){
            last = head;
            int x=0;
            while(x<k){
                if(x!=k-1&&last.next==null){
                    break out;
                }
                last=last.next;
                x++;
            }

            ListNode reverse = reverse(head, last, k);
//            System.out.println(reverse);
            if(a){
                root=reverse;
            }else {
                lHead.next=reverse;
            }
            lHead=head;
            head=last;
            a=false;
        }


        return root;
    }
    //1->2->3   3->2->1
    private static ListNode reverse(ListNode root,ListNode last,int k){
        int x=0;
        ListNode next;
        while(x<k){
            next=root.next;
            root.next=last;
            last=root;
            root=next;
            x++;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode root1=new ListNode(2);
        ListNode root2=new ListNode(3);
        ListNode root3=new ListNode(4);
        root.next=root1;
        root1.next=root2;
        root2.next=root3;
        root3.next=null;
        ListNode reverse = reverseKGroup(root, 2);
        while(reverse!=null){
            System.out.println(reverse);
            reverse=reverse.next;
        }
    }























}

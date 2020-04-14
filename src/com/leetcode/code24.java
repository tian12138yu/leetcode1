package com.leetcode;



/**
 * @Author tjy
 * @Date 2020/4/8 14:31
 */

/**
 * 1->2->3->4->5
 *
 * 转换3  4
 * 先把2next指向4，新建节点存4的next，然后将4的next变为3，在将3的next变为刚存储的节点。
 */

public class code24 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
  }
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode root=head.next;
        boolean isHead= true;
        while(head!=null&&head.next!=null){
            swap(head,isHead);
            if(isHead){
                isHead=false;

            }else {
                head=head.next.next;
            }
            isHead=false;
        }
        return root;

    }

    public static void swap(ListNode node,boolean isHead){
        ListNode pre;
        ListNode last;
        if(isHead){
            last=node.next.next;
            node.next.next=node;
            node.next=last;
        }else {
            if(node.next.next==null)return;
            pre=node.next;//3
            node.next=node.next.next;//2-4
            last=node.next.next;//5
            node.next.next=pre;//2-4-3
            pre.next=last;//2-4-3-5
        }

    }
}

package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/22 14:13
 */


/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class hebingLink {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //1 3 5 7
    //2 4 6 8
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 ==null && list2 == null)return null;

        if (list1 ==null || list2 == null)return list1 == null ? list2 : list1;
        ListNode head;
        if (list1.val >= list2.val){
            head = list2;
            list2 = list2.next;

        }
        else {
            head = list1;
            list1 = list1.next;
        }

        link(head,list1,list2);

        return head;
    }

    private static void link(ListNode head, ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null){
            if (list1.val >= list2.val){
                head.next = list2;
                list2 = list2.next;
            }
            else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;

        }

        if (list1 == null){
            head.next = list2;
        }else {
            head.next = list1;
        }

    }


    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(3);
        root1.next.next = new ListNode(5);
        root1.next.next.next = null;
        ListNode root2 = new ListNode(4);
        root2.next = new ListNode(5);
        root2.next.next = new ListNode(6);
        root2.next.next.next = null;
        ListNode merge = Merge(root1, root2);
        while (merge != null){
            System.out.print(merge.val+"->");
            merge = merge.next;
        }
        System.out.println("null");
    }
}

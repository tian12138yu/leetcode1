package com.offer;

/**
 * @Author tjy
 * @Date 2020/4/25 19:42
 */


/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteLinked {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead.val == pHead.next.val)pHead = pHead.next.next;
        if (pHead == null)return null;
        if (pHead.next == null)return pHead;
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        ListNode next = pHead.next.next;
        while (cur != null ){
            while (next != null && cur.val == next.val){
                next = next.next;
            }
            pre.next = next;

            cur = next;
            if (next != null){
                next = next.next;
            }
        }
        return pHead;
    }


    public ListNode deleteDuplication1(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(2);
        root1.next.next.next = new ListNode(3);
        root1.next.next.next.next = null;
        ListNode listNode = deleteDuplication(root1);
        while (listNode != null){
            System.out.println(listNode.val+ "  ");
            listNode = listNode.next;
        }
    }
}

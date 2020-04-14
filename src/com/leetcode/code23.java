package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/4/10 14:39
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
public class code23 {
    public static class ListNode implements Comparable<ListNode> {
      public int val;

      public ListNode next;
      public ListNode(int x) { val = x; }

        @Override
        public int compareTo(ListNode o) {
            if(o.val>this.val){
                return -1;
            }else if(o.val<this.val){
                return 1;
            }else {
                return 0;
            }

        }

        @Override
        public String toString() {
            return val+"->";
        }
    }

    public static void main(String[] args) {
        ListNode root1=new ListNode(1);
        ListNode root2=new ListNode(1);
        ListNode root3=new ListNode(2);
        root1.next=new ListNode(4);
        root1.next.next=new ListNode(5);
        root2.next=new ListNode(3);
        root2.next.next=new ListNode(4);
        root3.next=new ListNode(6);
        ListNode[] lists=new ListNode[3];
        lists[0]=root1;
        lists[1]=root2;
        lists[2]=root3;
        ListNode node = mergeKLists(lists);
        while (node!=null){
            System.out.print(node);
            node=node.next;
        }

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode node=lists[i];
            while(node!=null){
                listNodes.add(node);
                node=node.next;
            }
        }
        Collections.sort(listNodes);
        int x=1;
        ListNode root=listNodes.get(0);
        while (x<listNodes.size()){
            root.next=listNodes.get(x);
            root=root.next;
            x++;
        }

        return listNodes.get(0);

    }
}

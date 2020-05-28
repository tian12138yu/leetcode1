package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/28 18:42
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class code138 {

    public Node copyRandomList(Node head) {
        if (head == null)return head;
        Node cur = head;
        Node pre = null;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            if (map.containsKey(cur)){
                map.get(cur).random = node;
            }
            if (pre != null){
                pre.next = node;
                pre = node;
            }else {
                head = node;
                pre = node;
            }
            map.put(cur.random,node);
            cur = cur.next;

        }
        return head;
    }

    public Node copyRandomList1(Node head) {
        if (head == null)return head;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

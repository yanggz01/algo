package com.ifeng.yanggz.day1.linkedlist;

/**
 * 1、单链表反转
 * 2、链表中环的检测
 * 3、两个有序链表的合并
 * 4、删除链表中倒数第n个节点
 * 5、求链表的中间节点
 *
 */
public class LinkedListAlgo {

    // 单链表反转
    public static Node reverse(Node node) {
        Node pre = null;
        Node cur = node;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;

            cur = next;
        }
        return pre;
    }
    // 环检测
    public static boolean isCircle(Node list) {
        if(list == null) return false;

        Node slow = list;
        Node fast = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
    // 有序链表合并
    public static Node merge(Node la, Node lb) {
        if(la == null) return lb;
        if(lb == null) return la;
        Node p = la;
        Node q = lb;
        Node head;

        // 选头部
        if(p.data > q.data) {
            head = q;
            q = q.next;
        } else {
            head = p.next;
            p = p.next;
        }
        // 合并后链表指针r
        Node r = head;
        while (q != null && p != null) {
            if(p.data > q.data) {
                r.next = q;
                q = q.next;
            }else {
                r.next = p;
                p = p.next;
            }
            r = r.next;
        }
        // 接尾部
        if(q != null) {
            r.next = q;
        }
        if(p != null) {
            r.next = p;
        }
        return head;
    }

    // 删除倒数第n个节点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int count = 0;
        while (fast != null && count < k) {
            fast = fast.next;
            count++;
        }
        if(fast == null) {
            return list;
        }
        Node slow = list;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }

    // 求链表的中间节点
    public static Node getMiddle(Node list) {
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


}

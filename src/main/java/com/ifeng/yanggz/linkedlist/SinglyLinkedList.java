package com.ifeng.yanggz.linkedlist;

/**
 * 1、单链表的增删查
 * 2、链表回文检查
 */
public class SinglyLinkedList {

    private Node head = null;

    // 链表节点
    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    // 按值查找节点
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }
    // 按索引查找节点
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }
    // 无头节点按值插入
    public void insertToHead(int value) {
        Node node = new Node(value, null);
        insertToHead(node);
    }
    // 无头节点按节点插入
    public void insertToHead(Node node) {
        if(head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
    // 插入尾部（按值）
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if(head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }
    // 插入某个节点后面（按值插入）
    public void insertNodeAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertNodeAfter(p, newNode);
    }
    // 插入某个节点后面（按节点插入）
    public void insertNodeAfter(Node p, Node newNode) {
        if(p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    // 插入某个节点前面（按值插入）
    public void insertNodeBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertNodeBefore(p, newNode);
    }

    // 插入某个节点前面（按节点插入）
    public void insertNodeBefore(Node p, Node newNode) {
        if(p == null) {
            return;
        }
        if(p == head) {
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        newNode.next = p;
        q.next = newNode;
    }

    // 按节点删除
    public void deleteByNode(Node node) {
        if(head == null || node == null) {
            return;
        }
        if(head == node) {
            head = head.next;
        }
        Node p = head;
        while (p != null && p.next != node) {
            p = p.next;
        }

        if(p == null) {
            return;
        }
        p.next = node.next;
    }
    // 按值删除
    public void deleteByValue(int value) {
       if(head == null) {
           return;
       }

       Node p = head;
       Node q = null;
       while (p != null && p.data != value) {
           q = p;
           p = p.next;
       }
       if(p == null) {
           return;
       }
       if(q == null) {
           head = head.next;
       } else {
           q.next = q.next.next;
       }

       // 删除所有值相同的节点
       /*if(head != null && head.data == value) {
           head = head.next;
       }
       Node pNode = head;
       while (pNode != null && pNode.next != null) {
           if(pNode.next.data == value) {
               pNode.next = pNode.next.next;
               continue;
           }
           pNode = pNode.next;
       }*/
    }
    // 打印链表
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    // 判断两个链表是否相同
    public boolean TFResult(Node left, Node right) {
        boolean flag = true;
        while (left != null && right != null) {
            if(left.data == right.data) {
                left = left.next;
                right = right.next;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        if(left != null || right != null) {
            flag = false;
        }

        return flag;
    }

    // 判断是否是回文
    public boolean palindrome() {
        if(head == null) {
            return false;
        }
        Node p = head;
        Node q = head;
        if(q.next == null) {
            return true;
        }
        while (p.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        Node rightLink;
        Node leftLink;
        if(q.next == null) {
            // p为中点，且链表节点个数为奇数个
            rightLink = p.next;
            leftLink = inverseLinkedList(p).next;
        } else {
            // p、p.next 都为中点
            rightLink = p.next;
            leftLink = inverseLinkedList(p);
        }
        return TFResult(leftLink, rightLink);

    }

    // 无头链表反转
    private Node inverseLinkedList(Node p) {
        Node pre = null;
        Node cur = head;
        Node next;
        while (cur != p) {
            next = cur.next;
            cur.next = pre;
            pre = cur;

            cur = next;

        }
        return cur;
    }

    // 带头节点链表反转
    public Node inverseLinkedList_head(Node p) {
        Node head = new Node(9999, null);
        head.next = p;
        Node cur = p.next;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;

            cur = next;
        }
        return head;
    }

    // 创建一个节点
    public Node createNode(int value) {
        return new Node(value, null);
    }
}

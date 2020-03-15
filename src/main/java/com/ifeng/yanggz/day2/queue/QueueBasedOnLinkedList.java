package com.ifeng.yanggz.day2.queue;

/**
 * 基于链表实现队列
 * @Author yanggz
 * @Date 2020-01-03
 *
 */
public class QueueBasedOnLinkedList {
    // 队列头部
    private Node head = null;
    // 队列尾部
    private Node tail = null;

    // 入队
    public void enqueue(String value) {
        if(tail == null) {
            Node newNode = new Node(value, null);
            tail = newNode;
            head = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }

    }
    // 出队
    public String dequeue() {
        if(head == null) {
            return null;
        }
        String value = head.getValue();
        head = head.getNext();
        if(head == null) {
            tail = null;
        }
        return value;
    }
    // 打印
    public void printAll() {
        Node node = head;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public static class Node {
        private String value;
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public String getValue() {
            return value;
        }
    }
}

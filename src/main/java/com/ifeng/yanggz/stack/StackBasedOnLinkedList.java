package com.ifeng.yanggz.stack;

/**
 * 基于链表实现栈数据结构
 * @Author yanggz
 * @Date 2020-01-02
 */
public class StackBasedOnLinkedList {

    // 栈顶
    private Node top;

    // 压栈
    public void push(int data) {
        if(top == null) {
            top = new Node(data, null);
        } else {
            Node newNode = new Node(data, top);
            top = newNode;
        }
    }

    // 出栈
    public int pop() {
        if(top == null) {
            return -1;
        }
        int data = top.getData();
        top = top.next;
        return data;
    }

    // 打印栈
    public void printAll() {
        Node node = top;
        while (node != null) {
            System.out.print(node.getData() + ",");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node{

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

package com.ifeng.yanggz.queue;

/**
 * 数组实现循环队列
 * @Author yanggz
 * @Date 2020-01-03
 */
public class CircularQueue {
    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    // 初始化
    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String value) {
        if((tail+1) % n == head) {
            return false;
        }
        items[tail] = value;
        tail = (tail+1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        if(head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head+1) % n;
        return ret;
    }

    // 打印队列
    public void printAll() {
        for(int i=head; i != tail; i = (i+1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

package com.ifeng.yanggz.queue;

/**
 * 用数组实现的队列
 * @Author yanggz
 * @Date 2020-01-03
 *
 */
public class ArrayQueue {

    // 队列长度
    private int n;
    // 数组
    private String[] items;
    // 队列头部指针
    private int head = 0;
    // 队列尾部指针
    private int tail = 0;

    // 构造方法初始化队列
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String value) {
        if(tail == n) return false;
        items[tail++] = value;
        return true;
    }

    // 出队
    public String dequeue() {
        if(head == tail) return null;
        String item = items[head];
        head++;
        return item;
    }

    // 打印队列
    public void printAll() {
        for(int i=head; i<tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

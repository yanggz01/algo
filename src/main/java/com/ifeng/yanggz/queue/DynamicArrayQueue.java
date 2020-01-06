package com.ifeng.yanggz.queue;

import com.ifeng.yanggz.array.DynamicArray;

/**
 * 动态数组队列
 * @Author yanggz
 * @Date 2020-01-03
 */
public class DynamicArrayQueue {

    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    // 初始化
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    // 入队
    public boolean enqueue(String value) {
        if(tail == n) {
            if(head == 0) {
                return false;
            }
            // 搬移数据
            for(int i=head; i<tail; i++) {
                items[i-head] = items[i];
            }
            tail = tail-head;
            head = 0;
        }
        items[tail++] = value;
        return true;
    }

    // 出队
    public String dequeue() {
        if(head == tail) {
            return null;
        }
        String value = items[head];
        head++;
        return value;
    }
    // 打印
    public void printAll() {
        for (int i=head; i<tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

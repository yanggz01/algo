package com.ifeng.yanggz.day5.heap;

/**
 * 优先级队列
 */
public class PrimaryQueue implements Queue<Integer> {

    private Heap heap;

    public PrimaryQueue(int capaticty) {
        this.heap = new Heap(capaticty);
    }

    @Override
    public Integer peek() {
        return heap.getMax();
    }

    @Override
    public Integer dequeue() {
        return heap.removeTop();
    }

    @Override
    public void inqueue(Integer data) {
        heap.insert(data);
    }

    @Override
    public boolean isEmpty() {
        return heap.getCount() == 0;
    }

    @Override
    public int getSize() {
        return heap.getCount();
    }
}

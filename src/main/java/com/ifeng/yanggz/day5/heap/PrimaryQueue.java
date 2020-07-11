package com.ifeng.yanggz.day5.heap;

/**
 * 优先级队列
 */
public class PrimaryQueue implements Queue<Integer> {

    private Heap heap;

    public PrimaryQueue(Heap heap) {
        this.heap = heap;
    }

    @Override
    public Integer peek() {
        return heap.getMax();
    }

    @Override
    public Integer dequeue() {
        return heap.removeMax();
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

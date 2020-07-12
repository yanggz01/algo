package com.ifeng.yanggz.day5.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求一组动态数据集合的top k数据
 */
public class TopK {

    private List<Integer> dynamicList;
    // 小顶堆
    private Heap heap;

    public TopK(int k) {
        heap = new Heap(k);
        dynamicList = new ArrayList<>();
    }

    public int[] getTopK() {
        return heap.getAllData();
    }

    /**
     * 插入数据
     * @param data
     */
    public void insert(int data) {
        dynamicList.add(data);
        if(heap.getCount() < heap.getCapacity()) {
            heap.insert(data);
        }else if(data > heap.getMax()){
            heap.removeTop();
            heap.insert(data);
        }
    }

    public static void main(String[] args) {
        TopK topK = new TopK(5);
        topK.insert(3);
        topK.insert(2);
        topK.insert(44);
        topK.insert(12);
        topK.insert(32);
        topK.insert(1);
        topK.insert(4);
        topK.insert(21);
        topK.insert(9);
        topK.insert(11);
        topK.insert(5);

        int[] topKArr = topK.getTopK();
        System.out.println(Arrays.toString(topKArr));
    }
}

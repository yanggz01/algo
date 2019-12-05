package com.ifeng.yanggz.array;

/**
 * 1、固定大小有序数组
 * 2、支持增删改查
 *
 * @Author yanggz
 * @Date 2019-12-04
 */
public class FixedSortArray {

    private int[] data;
    private int size;

    public FixedSortArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造方法，默认大小为10
     */
    public FixedSortArray() {
        this(10);
    }

    // 获取数组大小
    public int count() {
        return size;
    }

    // 插入元素
    public void add(int value) {
        if(size == data.length) {
            throw new RuntimeException("Add failed! Array capacity is full.");
        }
        if(size == 0) {
            data[0] = value;
            size++;
            return;
        }
        for(int i=0; i<size; i++) {
            if(data[i] > value) {
                for(int j=size-1; j>=i; j--) {
                    data[j+1] = data[j];
                }
                data[i] = value;
                size++;
                return;
            }
        }
        data[size] = value;
        size++;
    }
    // 查找某个元素的位置，找不到返回-1
    public int find(int value) {
        for(int i=0; i<size; i++) {
            if(data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // 删除元素
    public void remove(int value) {
        int index = find(value);
        if(index != -1) {
            removeByIndex(index);
        }
    }

    // 删除指定位置元素
    public void removeByIndex(int index) {
        checkIndex(index);
        for(int i=index; i<size-1; i++) {
            data[i] = data[i+1];
        }
        data[size] = 0;
        size--;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal! Required index >=0 and index <= size.");
        }
    }

    // 打印数组
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d,capacity = %d \n", size, data.length));
        stringBuilder.append("[");
        for (int i=0; i<size; i++) {
            stringBuilder.append(data[i]);
            if(i != size-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

}

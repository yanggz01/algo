package com.ifeng.yanggz.array;

/**
 * 数组，支持动态扩容
 * @Author yanggz
 * @Date 2019-12-04
 */
public class DynamicArray<T> {

    private T[] data;
    private int size;

    public DynamicArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参构造方法
     */
    public DynamicArray() {
        this(0);
    }

    // 获取数组大小
    public int count() {
        return size;
    }
    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }
    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 查找某个位置元素
    public T get(int index) {
        // 校验位置范围
        checkIndex(index);
        return data[index];
    }

    public void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal! Require index >= 0 and index < size.");
        }
    }
    // 查询某个元素位置下标，未找到返回-1
    public int find(T obj) {
        for(int i=0; i<size; i++) {
            if(data[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    // 替换某个位置元素
    public void set(int index, T obj) {
        checkIndex(index);
        data[index] = obj;
    }

    // 在某个位置插入元素
    public void add(int index, T obj) {
        checkIndexForAdd(index);
        if(size == data.length) {
            // 扩容为原来的两倍
            resize(2 * size);
        }
        for(int i=size; i>=index; i--) {
            data[i] = data[i-1];
        }
        data[index] = obj;
        size++;
    }

    public void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for(int i=0; i<size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void checkIndexForAdd(int index) {
        if(index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed! Required index > 0 and index <= size");
        }
    }
    // 判断某个元素是否存在
    public boolean exist(T obj) {
        for (int i=0; i<size; i++) {
            if(data[i] == obj) {
                return true;
            }
        }
        return false;
    }

    // 删除某个元素
    public void removeElement(T obj) {
        int index = find(obj);
        if(index != -1) {
            remove(index);
        }
    }

    // 删除指定位置元素并返回
    public T remove(int index) {
        checkIndex(index);
        T obj = data[index];
        for(int i=index; i<size; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return obj;
    }

    // 删除头部元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除尾部元素
    public T removeLast() {
        return remove(size-1);
    }

    // 插入头部
    public void addFirst(T obj) {
        add(0, obj);
    }
    // 插入尾部
    public void addLast(T obj) {
        add(size, obj);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
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
}

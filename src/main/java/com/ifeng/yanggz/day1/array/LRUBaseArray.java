package com.ifeng.yanggz.day1.array;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的LRU缓存
 *
 * @Author yanggz
 * @Date 2019-12-23
 * 1、空间复杂度O(n)
 * 2、时间复杂度O(n)
 * 3、不支持null的缓存
 */
public class LRUBaseArray<T> {
    private static final int DEFAULT_CAPACITY = (1 << 3);

    private T[] value;

    private int count;

    private int capacity;

    private Map<T, Integer> holder;

    public LRUBaseArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap(capacity);
    }

    /**
     * 插入缓存
     *
     * @param value
     */
    public void offer(T value) {
        if(value == null) {
            throw new InvalidParameterException("Value can not be null!");
        }
        Integer index = holder.get(value);
        if(index == null) {
            if(isFull()) {
                // 删除最老的，然后缓存
                removeAndCache(value);
            } else {
                // 缓存
                cache(value, count);
            }
        } else {
            // 更新缓存索引
            update(index);
        }
    }

    public void cache(T object, int end) {
        // 右移
        rightShift(end);
        count++;
        value[0] = object;
        holder.put(object, 0);
    }

    /**
     * end 前的数据都向右移动一位
     * @param end
     */
    public void rightShift(int end) {
        for(int i=end-1; i>=0; i++) {
            value[i+1] = value[i];
            holder.put(value[i], i+1);
        }
    }

    public void removeAndCache(T object) {
        T key = value[count--];
        holder.remove(key);
        cache(object, count);
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean empty() {
        return count == 0;
    }


    /**
     * 更新索引
     *
     * @param index
     */
    private void update(Integer index) {
        T key = value[index];
        rightShift(index);
        value[0] = key;
        holder.put(key, 0);
    }

    public boolean isContains(T object) {
        return holder.containsKey(object);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<count; i++) {
            stringBuilder.append(value[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}

package com.ifeng.yanggz.day5.heap;

/**
 * 创建大顶堆
 * 创建小顶堆
 * 使用堆构建一个优先级队列
 */
public class Heap {

    // 数组存储完全二叉树
    private int[] a;
    // 堆允许存储的最大元素个数
    private int n;
    // 堆实际元素个数
    private int count;

    public Heap(int capacity) {
        // 初始化数组，从第二个位置存储数据
        this.a = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    // 数组原地构建大顶堆
    public static void build(int[] a, int n) {
        for(int i=n/2; i>=1; i--) {
            heapMax(a, n, i);
        }
    }

    // 大顶堆化
    public static void heapMax(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if(2*i <= n && a[maxPos] < a[2*i]) {
                maxPos = 2 * i;
            }
            if(2*i+1 <= n && a[maxPos] < a[2*i+1]) {
                maxPos = 2 * i + 1;
            }
            if(maxPos == i) {
                break;
            }
            swap(a, maxPos, i);
            i = maxPos;
        }
    }

    // 小顶堆化
    public static void heapMin(int[] a, int n, int i) {
        while (true) {
            int minPos = i;
            if(2*i <= n && a[minPos] > a[2*i]) {
                minPos = 2 * i;
            }
            if(2*i+1 <= n && a[minPos] > a[2*i+1]) {
                minPos = 2 * i + 1;
            }
            if(minPos == i) {
                break;
            }
            swap(a, minPos, i);
            i = minPos;
        }
    }

    // 交换节点
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 插入节点
    public void insert(int data) {
        if(count >= n) {
            return;// 堆满了
        }
        count++;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] < a[i/2]) {
            swap(a, i, i/2);
            i = i/2;
        }
    }

    // 删除堆顶节点
    public int removeTop() {
        if(count == 0) {
            return -1;
        }
        int max = a[1];
        a[1] = a[count];
        count--;
        heapMin(a, count, 1);
        return max;
    }

    // 堆排序
    public static void heapSort(int[] a) {
        build(a, a.length-1);
        int k = a.length-1;
        while (k>1) {
            swap(a, 1, k);
            k--;
            heapMax(a, k, 1);
        }
    }

    // 获取大小
    public int getCount() {
        return count;
    }

    // 获取堆顶元素
    public int getMax() {
        return a[1];
    }

    // 获取堆中所有元素
    public int[] getAllData() {
        return a;
    }

    // 获取堆的容量
    public int getCapacity() {
        return n;
    }
}

package com.ifeng.yanggz.day3.sorts;

import java.util.Arrays;

/**
 * 堆排序
 * @author yanggz
 * @date 2020-3-5
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 11, 5, 7, 0, 12};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序
     * @param arr
     */
    public static void sort(int[] arr) {
        if(arr.length <=1) {
            return;
        }

        // 建堆
        buildHeap(arr, arr.length-1);

        // 排序
        int k = arr.length-1;
        while (k>0) {
            swap(arr, 0, k);
            heapify(arr, --k, 0);
        }
    }

    /**
     * 建堆
     * @param arr
     * @param n
     */
    public static void buildHeap(int[] arr, int n) {
        for(int i=n/2; i>=0; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     * 堆化
     * @param arr
     * @param n
     * @param i
     */
    public static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxpos = i;
            if(2*i+1 <= n && arr[maxpos] < arr[2*i+1]) {
                maxpos = 2*i+1;
            }
            if(2*i+2 <= n && arr[maxpos] < arr[2*i+2]) {
                maxpos = 2*i+2;
            }
            if(maxpos == i) {
                break;
            }
            swap(arr, maxpos, i);
            i = maxpos;
        }
    }

    /**
     * 交换值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

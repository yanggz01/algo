package com.ifeng.yanggz.sorts;

import java.util.Arrays;

/**
 *
 * 冒泡排序
 * 插入排序
 * 希尔排序
 * 选择排序
 * @Author yanggz
 * @Date 2020-01-06
 *
 */
public class Sorts {

    // 冒泡排序（往上浮）
    public static void bubbleSortUp(int[] a, int n) {
        if(n <= 1) return;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(a[j] < a[i]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }

    // 冒泡排序（往下沉）
    public static void bubbleSortDown(int[] a, int n) {
        if(n <= 1) return;

        for(int i=0; i<n; i++) {
            boolean flag = false;
            for(int j=0; j<n-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }

    // 冒泡排序改进版
    public static void bubbleSort2(int[] a, int n) {

        if(n <= 1)return;
        int lastExchange = 0;
        int sortBorder = n-1;
        for(int i=0; i<n; i++) {
            boolean flag = false;
            for(int j=0; j<sortBorder; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if(!flag) {
                break;
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] a, int n) {
        if(n <= 1) return;

        for(int i=1; i<n-1; i++) {
            int value = a[i];
            int j = i-1;
            for(; j>=0; j--) {
                if(a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    // 希尔排序
    public static void shellSort(int[] a, int n) {
        if(n <= 1)return;
        int step = n/2;
        while (step >= 1) {
            for(int i=step; i<n; i++) {
                int value = a[i];
                int j = i-step;
                for(; j>=0; j = j-step) {
                    if(value < a[j]) {
                        a[j+step] = a[j];
                    } else {
                        break;
                    }
                }
                a[j+step] = value;
            }
            step = step / 2;
        }
    }

    // 选择排序
    public static void selectionSort(int[] a, int n) {
        if(n <= 1) return;
        for(int i=0; i<n-1; i++) {
            int minIndex = i;
            for(int j=i+1; j<n; j++) {
                if(a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] a = {2,1,6,4,3,7,11,10};
        System.out.println(Arrays.toString(a));
        Sorts.shellSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}

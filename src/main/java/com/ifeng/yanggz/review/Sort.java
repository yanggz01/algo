package com.ifeng.yanggz.review;

import java.util.Arrays;

/**
 * 排序复习
 */
public class Sort {


    /**
     * 归并排序
     *
     * @param a
     * @param p
     * @param r
     */
    public static void mergeSort(int[] a, int p, int r) {
        if(p >= r) {
            return;
        }
        int q = p + (r-p)/2;
        mergeSort(a, p, q);
        mergeSort(a, q+1, r);
        merge(a, p, q, r);
    }


    /**
     * 合并函数
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    public static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] tmp = new int[r-p+1];

        while (i<=q && j<=r) {
            if(a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        int start = j;
        int end = r;

        if(j>r) {
            start = i;
            end = q;
        }

        for(i=start; i<=end; i++) {
            tmp[k++] = a[i];
        }

        for(j=0; j<r-p+1; j++) {
            a[p+j] = tmp[j];
        }

    }


    /**
     * 选择排序
     *
     * @param a
     * @param n
     */
    public static void selectSort(int[] a, int n) {
        for(int i=0; i<n; i++) {
            int minValue = a[i];
            for(int j=i; j<n; j++) {
                if(a[j] < minValue) {
                    int tmp = a[j];
                    a[j] = minValue;
                    minValue = tmp;
                }
            }
            a[i] = minValue;
        }
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        for(int i=0; i<n; i++) {
            boolean flag = false;
            int lastSort = n-1;
            for(int j=0; j<lastSort; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true;
                    lastSort = j;
                }
            }
            if(flag == false) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * @param a
     * @param n
     */
    public static void insertSort(int[] a, int n) {
        for(int i=1; i<n; i++) {
            int j = i-1;
            int value = a[i];
            for(;j>=0; j--) {
                if(a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    /**
     * 快速排序
     *
     * @param a
     * @param p
     * @param r
     */
    public static void quickSort(int[] a, int p, int r) {
        if(p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSort(a, p, q-1);
        quickSort(a, q+1, r);
    }

    /**
     * 计算分区点
     *
     * @param a
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] a, int p, int r) {
        int pvoit = a[r];
        int i = p;

        for(int j=p; j<r; j++) {
            if(a[j] < pvoit) {
                if(i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }



    public static void main(String[] args) {
        int[] a = {2,5,88,11,3,8};
        //insertSort(a, a.length);
        //quickSort(a, 0, a.length-1);
        //bubbleSort(a, a.length);
        //selectSort(a, a.length);
        mergeSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}

package com.ifeng.yanggz.day7;

import java.util.Arrays;

/**
 *分治算法计算一个数组的逆序对个数
 * @Author yanggz
 * @Date 2020-08-01
 */
public class DividerAndConquer {

    private int num;

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if(p >= r) {
            return;
        }
        int q = (p + r)/2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q+1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r-p+1];
        int i = p;
        int j = q+1;
        int k = 0;

        while (i<=q && j <=r) {
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (q-i+1);
                tmp[k++] = a[j++];
            }
        }

        while (i<=q) {
            tmp[k++] = a[i++];
        }

        while (j<=r) {
            tmp[k++] = a[j++];
        }

        for(i=0; i<=r-p; i++) {
            a[p+i] = tmp[i];
        }
    }

    public static void main(String[] args) {

        int[] a = {2, 4, 3, 1, 5, 6};

        DividerAndConquer dividerAndConquer = new DividerAndConquer();
        dividerAndConquer.count(a, a.length);
        System.out.println(Arrays.toString(a));
        System.out.println("num:" + dividerAndConquer.num);
    }
}

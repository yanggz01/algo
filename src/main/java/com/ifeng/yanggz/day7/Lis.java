package com.ifeng.yanggz.day7;

import java.util.Arrays;

/**
 * 求一个数组的最长递增子序列
 *
 * 动态规划
 *
 */
public class Lis {

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,1,18};
        int r = lis(a, a.length);
        System.out.println(r);
    }


    /**
     * O(n*log(n))
     *
     * @param a
     * @param n
     * @return
     */
    public static int lis2(int[] a, int n) {
        int[] h = new int[n];
        int max = 0;
        h[max] = a[0];
        for(int i=1; i<n; i++) {
            if(a[i] > h[max]) {
                h[++max] = a[i];
            } else {
                int j = binarySearchFirstBigger(h, 0, max, a[i]);
                h[j] = a[i];
            }
            System.out.println(Arrays.toString(h));
        }

        return max+1;
    }

    /**
     * 查找第一个大于val的位置
     *
     * @param h
     * @param start
     * @param end
     * @param val
     * @return
     */
    private static int binarySearchFirstBigger(int[] h, int start, int end, int val) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low+high)/2;
            if(h[mid] >= val) {
                if(mid == 0 || h[mid-1] < val) {
                    return mid;
                } else {
                    high--;
                }
            } else {
                low = mid+1;
            }
        }
        return -1;
    }


    /**
     * O(n2)
     *
     * @param a
     * @param n
     * @return
     */
    public static int lis(int[] a, int n) {
        int[] h = new int[n];
        for(int i=0; i<n; i++) {
            h[i] = 1;
            for(int j=0; j<i; j++) {
                if(a[j] < a[i]) {
                    h[i] = Math.max(h[i], h[j]+1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            if(h[i] > max) {
                max = h[i];
            }
        }
        System.out.println(Arrays.toString(h));
        return max;
    }
}

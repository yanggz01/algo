package com.ifeng.yanggz.day3.sorts;

import java.util.Arrays;

/**
 * 基数排序
 * 计数排序
 * 桶排序
 * @Author yanggz
 * @Date 2020-01-15
 */
public class Sorts3 {

    public static void main(String[] args) {
        int[] array = {2,5,7,3,1,6,44};
        int[] array2 = {5557,223,516,721,325,111,624,4477};
        System.out.println(Arrays.toString(array2));
        //Sorts3.bucketSort(array, 3);
        //Sorts3.countSort(array, array.length);
        Sorts3.radixSort(array2, array2.length);
        System.out.println(Arrays.toString(array2));
    }

    /**
     * 基数排序
     * @param a
     * @param n
     */
    public static void radixSort(int[] a, int n) {
        if(n <=1 ) {
            return;
        }
        // 求最大值
        int max = a[0];
        for(int i=1; i<n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        // 对数组中值从低位到高位计数排序
        for(int exp=1; max/exp > 0; exp *= 10) {
            countSort2(a, n, exp);
        }
    }

    private static void countSort2(int[] a, int n, int exp) {
        int[] c = new int[10];
        for(int i=0; i<n; i++) {
            c[(a[i]/exp)%10]++;
        }
        for(int j=1; j<=9; j++) {
            c[j] = c[j-1] + c[j];
        }
        int[] r = new int[n];
        for(int k=n-1; k>=0; k--) {
            int index = c[(a[k]/exp)%10]-1;
            r[index] = a[k];
            c[(a[k]/exp)%10]--;
        }
        for(int i=0; i<n; i++) {
            a[i] = r[i];
        }
    }


    /**
     * 计数排序
     * @param a
     * @param n
     */
    public static void countSort(int[] a, int n) {
        if(n<=1) {
            return;
        }
        // 算出数组最大值
        int max = a[0];
        for(int i=1; i<n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        // 申请max+1大的数组，存各个值的个数
        int[] t = new int[max+1];
        for(int i=0; i<n; i++) {
            t[a[i]]++;
        }
        // 申请新数组累加各值的个数
        for(int j=1; j<=max; j++) {
            t[j] = t[j-1] + t[j];
        }
        // 申请临时数组按顺序存入各值
        int[] r = new int[n];
        for(int k=n-1; k>=0; k--) {
            int index = t[a[k]]-1;
            r[index] = a[k];
            t[a[k]]--;
        }
        // 将临时数组赋值给a
        for(int i=0; i<n; i++) {
            a[i] = r[i];
        }
    }


    /**
     * 桶排序
     * @param arr
     * @param bucketSize
     */
    public static void bucketSort(int[] arr, int bucketSize) {

        // 求最大值和最小值
        int maxValue = arr[0];
        int minValue = arr[1];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < minValue) {
                minValue = arr[i];
            }
            if(arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // 桶的数量
        int bucketCount = (maxValue-minValue) / bucketSize + 1;
        // 创建桶，并将数据填充到桶里
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];
        for(int j=0; j<arr.length; j++) {
            int bucketIndex = (arr[j]-minValue) / bucketSize;
            // 如果某个桶超过了大小，扩容
            if(indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[j];
        }

        // 将每个桶里的数据快排算法排序
        int j=0;
        for(int k=0; k<buckets.length; k++) {
            if(indexArr[k] == 0){
                continue;
            }
            quickSort(buckets[k], 0, indexArr[k]-1);
            for(int i=0; i<indexArr[k]; i++) {
                arr[j++] = buckets[k][i];
            }
        }
    }

    // 实现快速排序
    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        // 获取分区点
        int p = partition3(arr, left, right);

        quickSort(arr, left, p-1);
        quickSort(arr, p+1, right);
    }

    private static int partition3(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for(int j=left; j<right; j++) {
            if(arr[j] <= pivot) {
                if(i==j) {
                    i++;
                } else {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i++] = tmp;
                }
            }
        }
        int tmp = arr[right];
        arr[right] = arr[i];
        arr[i] = tmp;
        return i;
    }

    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tmpArr = buckets[bucketIndex];
        int[] newArr = new int[tmpArr.length*2];
        for(int i=0; i<tmpArr.length; i++) {
            newArr[i] = tmpArr[i];
        }
        buckets[bucketIndex] = newArr;
    }
}

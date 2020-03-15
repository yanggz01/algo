package com.ifeng.yanggz.day1.array;
/**
 * 合并两个有序数组
 * @Author yanggz
 * @Date 2019-12-05
 */
public class MergeSortArray {
    /**
     * 合并两个有序数组
     * @param array1
     * @param array2
     */
    public static int[] merge(int[] array1, int[] array2) {
        // 申请一个新数组，大小为容量为两个数组的大小之和
        int size = array1.length + array2.length;
        int[] newArray = new int[size];
        int m=0,n=0;
        for(int i=0; i<size; i++) {
            // 数组二到末尾
            if(m < array1.length && n == array2.length) {
                newArray[i] = array1[m];
                m++;
                continue;
            }
            // 数组一到末尾
            if(m == array1.length && n < array2.length) {
                newArray[i] = array2[n];
                n++;
                continue;
            }
            if(array1[m] > array2[n]) {
                newArray[i] = array2[n];
                n++;
            } else {
                newArray[i] = array1[m];
                m++;
            }
        }
        return newArray;
    }

    public static void printAll(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<array.length; i++) {
            stringBuilder.append(array[i]);
            if(i != array.length -1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        stringBuilder.append(String.format("size=%d", array.length));
        System.out.println(stringBuilder.toString());
    }
}

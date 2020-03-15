package com.ifeng.yanggz.day3.search;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,4,5,6,6,6,6,8,11,13,14};
        int index = bsearch3(arr, arr.length, 6);
        System.out.println(index);
    }

    /**
     * 二分查找
     * @param arr
     *          数组
     * @param n
     *          数组长度
     * @param value
     *          查找的值
     * @return
     *        返回查找值在数组中的位置，不存在返回-1
     */
    public static int bsearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int middle = low + (high-low)/2;
            if(arr[middle] == value) {
                return middle;
            } else if(arr[middle] > value) {
                high = middle-1;
            } else {
                low = middle+1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     *
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public static int bsearch2(int[] arr, int n, int value) {

        return bsearchInternally(arr, 0, n-1, value);
    }

    /**
     * 二分查找递归函数
     *
     * @param arr
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int bsearchInternally(int[] arr, int low, int high, int value) {
        if(low > high) {
            return -1;
        }
        int mid = low + ((high-low) >> 1);
        if(arr[mid] == value) {
            return mid;
        } else if(arr[mid] > value) {
            return bsearchInternally(arr, 0, mid-1, value);
        } else {
            return bsearchInternally(arr, mid+1, high, value);
        }
    }

    /**
     * 二分查找模糊查询
     *  查询第一个大于等于value的元素
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public static int bsearch3(int[] arr, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = low + ((high-low)>>1);
            if(arr[mid] >= value) {
                if((mid==0) || (arr[mid-1] < value)) {
                    return mid;
                }else {
                    high = mid-1;
                }
            } else {
                low = mid+1;
            }
        }

        return -1;
    }

}

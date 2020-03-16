package com.ifeng.yanggz.day3.sorts;

import java.util.Arrays;

/**
 *
 * 快速排序
 * 归并排序
 * @Author yanggz
 * @Date 2020-01-15
 */
public class Sorts2 {

    // 快速排序
    public static void quickSort(int[] a, int n) {
        if(n <= 1)return;
        quickSortInternally(a, 0, n-1);
    }
    // 递归函数
    public static void quickSortInternally(int[] a, int p, int r) {
        if(p >= r)return;
        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }
    // 分区点
    public static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j=p; j<r; j++) {
            if(a[j] < pivot) {
                if(i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[r];
        a[r] = a[i];
        a[i] = tmp;

        return i;
    }


    // 三位取中法获取分区点
    public static int partition2(int[] a, int p, int r) {

        int middle = (r - p) / 2;
        int pivot = a[middle];
        int right = a[r];
        a[r] = pivot;
        a[middle] = right;

        int i = p;
        for(int j=p; j<r; j++) {
            if(a[j] < pivot) {
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

    // 三向切分快速排序
    public static void quick3Sort(int[] a, int n) {
        if(n <= 1)return;

        quick3SortInternally2(a, 0, n-1);
    }

    public static void quick3SortInternally(int[] a, int l, int r) {
        if(l >= r) {
            return;
        }
        int pivot = a[l];
        int k = l+1;
        int left = l;
        int right = r;
        while (k<=right) {
            if(a[k] < pivot) {
                int tmp = a[left];
                a[left] = a[k];
                a[k] = tmp;
                k++;
                left++;
            } else if(a[k] > pivot) {
                int tmp  = a[right];
                a[right] = a[k];
                a[k] = tmp;
                right--;
            } else {
                k++;
            }
        }
        quick3SortInternally(a, l, left-1);
        quick3SortInternally(a, right+1, r);
    }

    public static void quick3SortInternally2(int[] a, int left, int right) {
        if(left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int k = left+1;
        int pivot = a[l];
        while (k <= r) {
            if(a[k] < pivot) {
                int tmp = a[k];
                a[k] = a[l];
                a[l] = tmp;
                k++;
                l++;
            } else if(a[k] == pivot) {
                k++;
            } else {
                if(a[r] > pivot) {
                    r--;
                } else if(a[r] == pivot) {
                    int tmp = a[r];
                    a[r] = a[k];
                    a[k] = tmp;
                    r--;
                    k++;
                } else {
                    int tmp = a[r];
                    a[r] = a[k];
                    a[k] = a[l];
                    a[l] = tmp;
                    r--;
                    k++;
                    l++;
                }
            }
        }
        quick3SortInternally2(a, left, l-1);
        quick3SortInternally2(a, r+1, right);
    }


    // 双轴快速排序
    public static void quickSort2Pivot(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int k = left+1;

        if(arr[l] > arr[r]) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        int pivot1 = arr[l];
        int pivot2 = arr[r];

        while (k<r) {
            if (arr[k] < pivot1) {
                l++;
                if (l != k) {
                    int tmp = arr[l];
                    arr[l] = arr[k];
                    arr[k] = tmp;
                }
                k++;
            } else if (arr[k] >= pivot1 && arr[k] <= pivot2) {
                k++;
            } else {
                --r;
                if (arr[r] > pivot2) {

                } else if (arr[r] >= pivot1 && arr[r] <= pivot2) {
                    int tmp = arr[r];
                    arr[r] = arr[k];
                    arr[k] = tmp;
                    k++;
                } else {
                    l++;
                    int tmp = arr[r];
                    arr[r] = arr[k];
                    arr[k] = arr[l];
                    arr[l] = tmp;
                    k++;
                }
            }
        }

        arr[left] = arr[l];
        arr[l] = pivot1;
        arr[right] = arr[r];
        arr[r] = pivot2;

        quickSort2Pivot(arr, left, l-1);
        quickSort2Pivot(arr, l+1, r-1);
        quickSort2Pivot(arr, r+1, right);

    }

    /**
     *
     * 归并排序
     *
     */
    // 归并排序
    public static void mergeSort(int[] a, int n) {
        if(n <= 1) return;
        mergeSortInternally(a, 0, n-1);
    }

    // 归并递归函数
    public static void mergeSortInternally(int[] a, int p, int r) {
        // 递归中止条件
        if(p >= r) return;

        int q = p + (r - p)/2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        // 合并
        //merge(a, p, q, r);
        mergeBySentry(a, p, q, r);
    }

    // 合并函数
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

        int start = i;
        int end = q;
        if(j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for(i=0; i<=r-p; i++) {
            a[p+i] = tmp[i];
        }
    }

    // 带哨兵合并函数
    public static void mergeBySentry(int[] a, int p, int q, int r) {

        int[] leftArr = new int[q-p+2];
        int[] rightArr = new int[r-q+1];

        for(int i=0; i<=q-p; i++) {
            leftArr[i] = a[p+i];
        }
        // 左边数组的哨兵
        leftArr[q-p+1] = Integer.MAX_VALUE;
        for(int j=0; j<r-q; j++) {
            rightArr[j] = a[q+1+j];
        }
        // 右边数组的哨兵
        rightArr[r-q] = Integer.MAX_VALUE;

        int i=0;
        int j=0;
        int k = p;
        while (k<=r) {
            if(leftArr[i] <= rightArr[j]) {
                a[k++] = leftArr[i++];
            } else {
                a[k++] = rightArr[j++];
            }
        }
    }

    /**
     * O(n) 时间复杂度查询第 K 大元素
     *
     */
    public static int kTh(int[] a, int q, int r, int k) {
        if(q >= r) {
            return 0;
        }

        int p = partition(a, q, r);
        if(p + 1 == k) {
            return a[p];
        } else if(p + 1 > k) {
            return kTh(a, q, p-1, k);
        } else {
            return kTh(a, p+1, r, k);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,6,4,3,7,11,10};
        System.out.println(Arrays.toString(a));
        Sorts2.quick3Sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}

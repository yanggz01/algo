package com.ifeng.yanggz.day5.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSortArray {

    public static void main(String[] args) {

        int[] arr1 = {0,5,8,10,13};
        int[] arr2 = {2,3,4,7,9};
        int[] arr3 = {1,6,12,14,15};

        int[] arr = new int[arr1.length+arr2.length+arr3.length];
        PrimaryQueue pq = new PrimaryQueue(3);

        Map<Integer, int[]> tmp = new HashMap();
        tmp.put(arr1[0], arr1);
        tmp.put(arr2[0], arr2);
        tmp.put(arr3[0], arr3);

        pq.inqueue(arr1[0]);
        pq.inqueue(arr2[0]);
        pq.inqueue(arr3[0]);

        int j=0,k=0,m=0;
        int i = 0;

        while (j<arr1.length || k<arr2.length || m<arr3.length) {

            int tmpMin = pq.dequeue();
            arr[i++] = tmpMin;

            if(i==arr.length) {
                break;
            }

            // 找到tmpMax对应的数组
            int [] a = tmp.get(tmpMin);

            if(a == arr1 && j < arr1.length-1) {
                j++;
                pq.inqueue(a[j]);
                tmp.put(a[j], a);
                continue;
            }
            if(a == arr2 && k < arr2.length-1) {
                k++;
                pq.inqueue(a[k]);
                tmp.put(a[k], a);
                continue;
            }
            if(a == arr3 && m < arr3.length -1) {
                m++;
                pq.inqueue(a[m]);
                tmp.put(a[m], a);
                continue;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

package com.ifeng.yanggz.day1.array;

public class ArrayMain {
    public static void main(String[] args) {

        FixedSortArray fixedArray = new FixedSortArray();
        fixedArray.add(9);
        fixedArray.add(2);
        fixedArray.add(3);
        fixedArray.add(1);
        fixedArray.add(7);
        fixedArray.add(5);
        fixedArray.print();
        fixedArray.remove(3);
        fixedArray.remove(7);
        fixedArray.print();

        DynamicArray array = new DynamicArray<Integer>(10);
        array.add(0, 2);
        array.add(1, 3);
        array.add(2, 7);
        array.add(3, 4);
        array.print();
        array.remove(2);
        array.print();
        array.remove(1);
        array.print();

        int[] array1 = {0,2,4,6,7,9,11};
        int[] array2 = {3,7,10,13,14};

        int[] mergeResult = MergeSortArray.merge(array1, array2);
        MergeSortArray.printAll(mergeResult);
    }
}

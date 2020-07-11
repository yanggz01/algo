package com.ifeng.yanggz.day5;

import com.ifeng.yanggz.day5.heap.Heap;
import com.ifeng.yanggz.day5.tree.BinarySearchTree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(33);
        binarySearchTree.insert(16);
        binarySearchTree.insert(50);
        binarySearchTree.insert(13);
        binarySearchTree.insert(18);
        binarySearchTree.insert(34);
        binarySearchTree.insert(58);
        binarySearchTree.insert(15);
        binarySearchTree.insert(17);
        binarySearchTree.insert(25);
        binarySearchTree.insert(51);
        binarySearchTree.insert(66);
        binarySearchTree.insert(19);
        binarySearchTree.insert(27);
        binarySearchTree.insert(55);

        BinarySearchTree binarySearchTree1 = new BinarySearchTree();
        binarySearchTree1.insert(13);
        binarySearchTree1.insert(12);
        binarySearchTree1.insert(15);

        //binarySearchTree.delete(18);
        //System.out.println(binarySearchTree.findPost(25).getData());
        //binarySearchTree.preOrderStack();
        //binarySearchTree.preOrder();
        //binarySearchTree.postOrderStack();

        int[] a = {0,7,5,19,8,4,1,20,13,16};
        System.out.println(Arrays.toString(a));
        //Heap.build(a, 9);
        Heap.heapSort(a);
        System.out.println(Arrays.toString(a));

    }
}

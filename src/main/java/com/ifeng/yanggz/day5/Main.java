package com.ifeng.yanggz.day5;

import com.ifeng.yanggz.day5.tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(11);

        System.out.println(binarySearchTree.findMax().getData());
        System.out.println(binarySearchTree.findMin().getData());

        binarySearchTree.delete(11);
        System.out.println(binarySearchTree.findMax().getData());
        System.out.println(binarySearchTree.find(3).getData());
    }
}

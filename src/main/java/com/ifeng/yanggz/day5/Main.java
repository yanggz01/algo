package com.ifeng.yanggz.day5;

import com.ifeng.yanggz.day5.tree.BinarySearchTree;

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

        //binarySearchTree.delete(18);
        //System.out.println(binarySearchTree.findPost(25).getData());
        //binarySearchTree.preOrderStack();
        //binarySearchTree.preOrder();
        binarySearchTree.levelOrderQueue();
    }
}

package com.ifeng.yanggz.leetcode;

import java.util.Arrays;

/**
 * 二叉树最小深度
 */
public class BinaryTreeMinDepth {

    public int minDepth(TreeNode tree) {

        return -1;
    }

    class TreeNode{
        int value;

        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,5,88,11,3,8};
        System.out.println(Arrays.toString(a));
    }
}

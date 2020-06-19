package com.ifeng.yanggz.day5.tree;

/**
 * 二叉查找树
 * @Author yanggz
 * @Date 2020-06-19
 *
 */
public class BinarySearchTree {

    private Node tree;

    // 查找
    public Node find(int data) {
        if(tree == null) {
            return null;
        }
        Node p = tree;
        while (p != null) {
            if(p.data > data) {
                p = p.left;
            } else if(p.data < data){
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 插入
    public void insert(int data) {
        if(tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if(p.data > data) {
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if(p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    // 删除
    public void delete(int data) {
        Node p = tree;
        Node pp = null; // p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if(p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if(p == null) {
            return; // 没有找到需要删除的节点
        }

        if(p.left != null && p.right != null) {
            // 找到最小节点
            Node minP = p;
            Node minPP = null;
            while (minP != null) {
                minPP = minP;
                minP = minP.left;
            }
            p = minP;
            pp = minPP;// 接下来删除p
        }

        // 找出p的child
        Node child;
        if(p.left != null) {
            child = p.left;
        } else if(p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if(pp == null) {// 删除的是根节点
            tree = child;
        } else if(pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    // 查找最大节点
    public Node findMax() {
        if(tree == null) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    // 查询最小节点
    public Node findMin() {
        if(tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    // 查找一个节点的前驱节点
    // 查找一个节点的后继节点
    // 二叉树前序遍历
    // 二叉树中序遍历
    // 二叉树后续遍历
    // 二叉树按层遍历

    public static class Node {
        // 数据
        private int data;
        // 左子节点
        private Node left;
        // 右子节点
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }
}

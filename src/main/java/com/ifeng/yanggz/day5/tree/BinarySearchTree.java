package com.ifeng.yanggz.day5.tree;

import java.util.*;

/**
 * 二叉查找树
 *
 * @Author yanggz
 * @Date 2020-06-19
 */
public class BinarySearchTree {

    private Node tree;

    // 查找
    public Node find(int data) {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p != null) {
            if (p.data > data) {
                p = p.left;
            } else if (p.data < data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 插入
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (p.data > data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
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
            if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // 没有找到需要删除的节点
        }

        if (p.left != null && p.right != null) {
            // 找到最小节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;// 接下来删除p
        }

        // 找出p的child
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {// 删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    // 查找最大节点
    public Node findMax() {
        if (tree == null) {
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
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    // 查找一个节点的前驱节点
    public Node findPre(int data) {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        Node parent; // 父节点
        Node lastRightP = null; // 最后一次右拐父节点
        while (p != null) {
            parent = p;
            if (p.data > data) {
                p = p.left;
            } else if (p.data < data) {
                lastRightP = p;
                p = p.right;
            } else {
                // 找到该节点
                // 1、如果该节点不存在左节点
                if (p.left == null) {
                    if (parent.right == p) {
                        return parent;
                    } else {
                        return lastRightP;
                    }
                }
                // 2、如果存在左节点，查找该节点左子树的最大节点
                Node pre = p.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                return pre;
            }
        }

        return null;
    }

    // 查找一个节点的后继节点
    public Node findPost(int data) {
        // 找到该节点
        if (tree == null) {
            return null;
        }
        Node p = tree;
        Node parent;
        Node lastLeftP = null;
        while (p != null) {
            parent = p;
            if (p.data > data) {
                lastLeftP = p;
                p = p.left;
            } else if (p.data < data) {
                p = p.right;
            } else {
                // 1、如果不存在右子树
                if (p.right == null) {
                    if (parent.left == p) {
                        return parent;
                    } else {
                        return lastLeftP;
                    }
                }
                // 2、查找该节点右子树的最小节点
                Node post = p.right;
                while (post.left != null) {
                    post = post.left;
                }
                return post;
            }
        }

        return null;
    }

    public void preOrder() {
        if (tree == null) {
            return;
        }
        Node root = tree;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            System.out.print(p.data + " ");
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    // 二叉树前序遍历
    public void preOrderStack() {
        if (tree == null) {
            return;
        }
        Node p = tree;
        Stack<Node> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.print(p.data + " ");
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
    }

    // 二叉树中序遍历
    public void inOrderStack() {
        if (tree == null) {
            return;
        }
        Node p = tree;
        Stack<Node> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.print(p.data + " ");
            p = p.right;
        }
    }


    // 二叉树后序遍历
    public void postOrderStack() {
        if(tree == null) {
            return;
        }
        Node root = tree;
        Map<Node, Boolean> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.peek();
            if(p.left != null && !map.containsKey(p.left)) {
                p = p.left;
                while (p != null) {
                    /*if(map.containsKey(p)) {
                        break;
                    } else {
                        stack.push(p);
                    }*/
                    stack.push(p);
                    p = p.left;
                }
                continue;
            }
            if(p.right != null && !map.containsKey(p.right)) {
                stack.push(p.right);
                continue;
            }
            Node t = stack.pop();
            System.out.print(t.data + " ");
            map.put(t, true);
        }
    }


    // 二叉树按层遍历
    public void levelOrderQueue() {
        if (tree == null) {
            return;
        }
        Node root = tree;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            System.out.print(p.data + " ");
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }
    }

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

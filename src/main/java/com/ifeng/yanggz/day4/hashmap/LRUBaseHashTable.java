package com.ifeng.yanggz.day4.hashmap;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;

/**
 * 基于hashmap的LRU算法
 * @Author yanggz
 * @Date 2020-06-13
 *
 * @param <K>
 * @param <V>
 */
public class LRUBaseHashTable<K, V> {
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 容量
    private int capacity;
    // 长度
    private int length;
    // HashMap
    private HashMap<K, DNode> table;
    // 头节点
    private DNode headNode;
    // 尾节点
    private DNode tailNode;

    public LRUBaseHashTable(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new DNode();
        this.tailNode = new DNode();

        headNode.next = tailNode;
        tailNode.pre = tailNode;

        table = new HashMap<>();
    }

    public LRUBaseHashTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 插入数据
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        DNode node = table.get(key);
        if(node == null) {
            node = new DNode(key, value);
            table.put(key, node);
            addNode(node);
            if(++length > capacity) {
                DNode<K, V> tailPre = tailNode.pre;
                remove(tailPre.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 查找数据
     *
     * @param key
     * @return
     */
    public V get(K key) {
        DNode<K, V> node = table.get(key);
        if(node == null) {
            return null;
        }
        // 移动到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 移动到头节点
     *
     * @param node
     */
    private void moveToHead(DNode<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 删除节点
     *
     * @param node
     */
    public void removeNode(DNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 插入头节点
     * @param node
     */
    public void addNode(DNode node) {
        node.next = headNode.next;
        node.pre = headNode;

        headNode.next.pre = node;
        headNode.next = node;
    }

    /**
     * 删除数据
     *
     * @param key
     */
    public void remove(K key) {
        DNode<K, V> node = table.get(key);
        if(node == null) {
            return;
        }
        removeNode(node);
        table.remove(key);
        length--;
    }

    public void printALL() {
        DNode node = headNode;
        while (node.next != tailNode) {
            node = node.next;
            if(node.next == tailNode) {
                System.out.print(node.value);
            } else {
                System.out.print(node.value + ",");
            }
        }
        System.out.println();
    }

    /**
     * 双向链表
     *
     * @param <K>
     * @param <V>
     */
    static class DNode<K, V> {
        private K key;

        private V value;
        // 前驱节点
        private DNode pre;
        // 后继节点
        private DNode next;

        DNode() {

        }

        DNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

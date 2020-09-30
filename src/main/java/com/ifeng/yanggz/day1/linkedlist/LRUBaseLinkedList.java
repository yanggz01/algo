package com.ifeng.yanggz.day1.linkedlist;

/**
 * 基于链表的缓存淘汰算法（LRU）
 * @author yanggz
 * @date 2019-12-23
 *
 */
public class LRUBaseLinkedList<T> {

    private static final Integer DEFAULT_CAPACITY = 10;

    private SNode<T> headNode;

    private int length;

    private int capacity;

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);
        if(preNode != null) {
            // 删除该节点
            deleteNextElem(preNode);
            // 插入该节点到头部
            insertIntoHead(data);
        } else {
            if(length == capacity) {
                // 删除尾节点
                deleteTailElem();
            }
            // 插入头节点
            insertIntoHead(data);
        }
    }

    private void deleteTailElem() {
        SNode sNode = headNode;
        while (sNode.getNext().getNext() != null) {
            sNode = sNode.getNext();
        }
        SNode tmp = sNode.getNext();
        sNode.setNext(null);
        tmp = null;
        length--;
    }

    private void insertIntoHead(T data) {
        SNode sNode = headNode.getNext();
        headNode.setNext(new SNode(data, sNode));
        length++;
    }

    private void deleteNextElem(SNode preNode) {
        SNode sNode = preNode.getNext();
        preNode.setNext(sNode.getNext());
        sNode = null;
        length--;
    }

    private SNode findPreNode(T data) {

        SNode sNode = headNode;
        while (sNode.getNext() != null) {
            if(data.equals(sNode.getNext().getElement())) {
                return sNode;
            }
            sNode = sNode.next;
        }
        return null;
    }

    public void printAll() {
        SNode sNode = headNode.getNext();
        while (sNode != null) {
            System.out.print(sNode.getElement());
            if(sNode.getNext() != null) {
                System.out.print(",");
            }
            sNode = sNode.getNext();
        }
        System.out.println();
    }

    public class SNode<T>{

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode() {
            this.next = null;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}

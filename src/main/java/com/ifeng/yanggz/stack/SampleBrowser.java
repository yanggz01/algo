package com.ifeng.yanggz.stack;

/**
 * 模拟浏览器的前进、后退
 * @Author yanggz
 * @Date 2020-01-02
 *
 */
public class SampleBrowser {

    private LinkedBasedStack forwardStack;
    private LinkedBasedStack backwardStack;
    private String currentUrl;

    public SampleBrowser() {
        this.forwardStack = new LinkedBasedStack();
        this.backwardStack = new LinkedBasedStack();
    }

    // 前进
    public String goForward() {
        if(canForward()) {
            backwardStack.push(currentUrl);
            String forwardUrl = forwardStack.pop();
            showUrl("Forward", forwardUrl);
            return forwardUrl;
        }
        System.out.println("Can not go forward, there is no pages exist!");
        return null;
    }

    // 后退
    public String goBack() {
        if(canBackward()) {
            forwardStack.push(currentUrl);
            String backUrl = backwardStack.pop();
            showUrl("Backward", backUrl);
            return backUrl;
        }
        System.out.println("Can not go back, there is no pages exist!");
        return null;
    }

    // 打开新页面
    public void open(String url) {
        if(currentUrl != null) {
            backwardStack.push(currentUrl);
            forwardStack.clear();
        }
        showUrl("open", url);
    }

    // 是否可以前进
    public boolean canForward() {
        if(forwardStack.size > 0) {
            return true;
        }
        return false;
    }

    // 是否可以后退
    public boolean canBackward() {
        if(backwardStack.size > 0) {
            return true;
        }
        return false;
    }
    // 检查当前页面
    public void checkCurrentUrl() {
        System.out.println("Current page:" + currentUrl);
    }
    // 打印url
    public void showUrl(String prefix, String url) {
        currentUrl = url;
        System.out.println(prefix + " page:" + url);
    }

    /**
     * 基于链表实现的栈
     */
    public static class LinkedBasedStack{
        private Node top;
        private int size;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }
        // 获取栈大小
        public int size() {
            return size;
        }
        // 压栈
        public void push(String data) {
            if(top == null) {
                top = new Node(data, null);
            } else {
                Node newNode = createNode(data, top);
                top = newNode;
            }
            size++;
        }
        // 出栈
        public String pop() {
            if(top == null) {
                return null;
            }
            String data = top.getData();
            top = top.getNext();
            if(size > 0) {
                size--;
            }
            return data;
        }
        // 清空栈
        public void clear() {
            top = null;
            size = 0;
        }
        // 打印栈
        public void printAll() {
            Node node = top;
            while (node != null) {
                System.out.print(node.getData() + ", ");
                node = node.next;
            }
            System.out.println();
        }

        /**
         * 栈节点
         */
        public static class Node{
            private String data;
            private Node next;

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }
            public String getData() {
                return data;
            }
            public void setData(String data) {
                this.data = data;
            }
            public Node getNext() {
                return next;
            }
            public void setNext(Node next) {
                this.next = next;
            }
        }
    }
}

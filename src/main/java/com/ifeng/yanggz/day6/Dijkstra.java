package com.ifeng.yanggz.day6;

import java.util.LinkedList;

/**
 * 最短路径算法
 */
public class Dijkstra {

    // 顶点个数
    private int v;
    // 邻接表
    private LinkedList<Edge>[] adj;

    public Dijkstra(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加一条边
     *
     * @param sid
     * @param tid
     * @param weight
     */
    public void addEdge(int sid, int tid, int weight) {
        adj[sid].add(new Edge(sid, tid, weight));
    }

    /**
     * 最短路径算法
     *
     * @param s
     * @param t
     */
    public void dijkstra(int s, int t) {
        int[] predecessor = new int[v];
        Vertex[] nodes = new Vertex[v];
        for(int i=0; i<v; i++) {
            nodes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(v);
        boolean[] inqueue = new boolean[v];
        nodes[s].dist = 0;
        queue.add(nodes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {

            Vertex vertex = queue.poll();
            if(vertex.id == t) {
                break;
            }

            for(int i=0; i<adj[vertex.id].size(); i++) {
                Edge e = adj[vertex.id].get(i);
                Vertex nextVertex = nodes[e.tid];
                if(vertex.dist + e.weight < nextVertex.dist) {
                    nextVertex.dist = vertex.dist + e.weight;
                    predecessor[nextVertex.id] = vertex.id;
                    if(inqueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }

        System.out.print(s);
        print(s, t, predecessor);
    }

    public void print(int s, int t, int[] predecessor) {
        if(s == t) {
            return;
        }
        print(s, predecessor[t], predecessor);
        System.out.print("-->"+t);
    }

    /**
     * 边
     */
    class Edge {
        // 原点
        public int sid;
        // 目标
        public int tid;
        // 边的权重
        public int weight;

        public Edge(int sid, int tid, int weight) {
            this.sid = sid;
            this.tid = tid;
            this.weight = weight;
        }
    }

    /**
     * 顶点
     */
    class Vertex {
        // 顶点id
        public int id;
        // 顶点到原点的距离
        public int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    /**
     * 优先级队列(小顶堆)
     */
    class PriorityQueue {

        private Vertex[] vertex;
        private int count;
        private int[] index;// 存储节点id在数组中的位置

        public PriorityQueue(int v) {
            vertex = new Vertex[v+1];
            index = new int[v];
            count = 0;
        }

        /**
         * 删除头节点
         * @return
         */
        public Vertex poll() {
            if(count == 0) {
                return null;
            }
            Vertex top = vertex[1];
            vertex[1] = vertex[count];
            index[vertex[count].id] = 1;
            count--;
            // 向下堆化
            heapify(vertex, count, 1);
            return top;
        }

        private void heapify(Vertex[] vertex, int count, int i) {
            while (true) {
                int minPos = i;
                if (2*i < count && vertex[i].dist>vertex[2*i].dist) {
                    minPos = 2*i;
                }
                if(2*i+1 < count && vertex[i].dist>vertex[2*i+1].dist) {
                    minPos = 2*i+1;
                }
                if(minPos == i) {
                    break;
                }
                swap(vertex, index, i, minPos);
                i = minPos;
            }
        }

        /**
         * 插入节点
         * @param node
         */
        public void add(Vertex node) {
            count++;
            vertex[count] = node;
            index[node.id] = count;
            int i=count;
            while (i/2>0 && vertex[i/2].dist > vertex[i].dist) {
                swap(vertex, index, i, i/2);
                i = i/2;
            }
        }

        /**
         * 更新节点
         * @param node
         */
        public void update(Vertex node) {
            int i = index[node.id];
            vertex[i].dist = node.dist;
            while (i/2 > 0 && vertex[i/2].dist > vertex[i].dist) {
                swap(vertex, index, i, i/2);
                i = i/2;
            }
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return count == 0;
        }


        public void swap(Vertex[] vertex, int[] index, int i, int j) {
            Vertex tmp = vertex[j];
            vertex[j] = vertex[i];
            vertex[i] = tmp;
            index[vertex[i].id] = j;
            index[vertex[j].id] = i;
        }
    }
}

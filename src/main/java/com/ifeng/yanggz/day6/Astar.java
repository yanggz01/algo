package com.ifeng.yanggz.day6;

import java.util.LinkedList;

/**
 * 最短路径算法
 */
public class Astar {

    // 顶点个数
    private int v;
    // 邻接表
    private LinkedList<Edge>[] adj;

    private Vertex[] vertexes;

    public Astar(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
        this.vertexes = new Vertex[v];
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
    public void aStar(int s, int t) {
        int[] predecessor = new int[v];
        PriorityQueue queue = new PriorityQueue(v);
        boolean[] inqueue = new boolean[v];
        vertexes[s].dist = 0;
        vertexes[s].f = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {

            Vertex vertex = queue.poll();

            for(int i=0; i<adj[vertex.id].size(); i++) {
                Edge e = adj[vertex.id].get(i);
                Vertex nextVertex = vertexes[e.tid];
                if(vertex.dist + e.weight < nextVertex.dist) {
                    nextVertex.dist = vertex.dist + e.weight;
                    nextVertex.f = nextVertex.dist + hManhattan(vertex, nextVertex);
                    predecessor[nextVertex.id] = vertex.id;
                    if(inqueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }

                if(nextVertex.id == t) {
                    queue.clear();
                    break;
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
        // 曼哈顿距离
        public int f;

        public int x;

        public int y;

        public Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.dist = Integer.MAX_VALUE;
            this.y = Integer.MAX_VALUE;
        }
    }

    public void addVertex(int id, int x, int y) {
        vertexes[id] = new Vertex(id, x, y);
    }

    public int hManhattan(Vertex t1, Vertex t2) {
        return Math.abs(t1.x-t2.x) + Math.abs(t1.y-t2.y);
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
                if (2*i < count && vertex[i].f>vertex[2*i].f) {
                    minPos = 2*i;
                }
                if(2*i+1 < count && vertex[i].f>vertex[2*i+1].f) {
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
            while (i/2>0 && vertex[i/2].f > vertex[i].f) {
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
            while (i/2 > 0 && vertex[i/2].f > vertex[i].f) {
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

        public void clear() {
            count = 0;
        }
    }
}

package com.ifeng.yanggz.day6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的表示
 *  1、邻接矩阵（略）
 *  2、邻接表
 * 图的搜索算法
 *  1、深度优先搜索
 *  2、广度优先搜索
 */
public class Graph {// 无向图

    private int v;    // 顶点个数
    private LinkedList<Integer>[] adj;// 邻接矩阵

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {// 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if(s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i=0; i<v; i++) {
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int j=0; j<adj[tmp].size(); j++) {
                int q = adj[tmp].get(j);
                if(!visited[q]) {
                    prev[q] = tmp;
                    if(q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    public void print(int[] prev, int s, int t) {
        if(prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    boolean found = false;
    /**
     * 深度优先搜索
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        int[] prev = new int[v];
        for(int i=0; i<v; i++) {
            prev[i] = -1;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    public void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if(found) {
            return;
        }
        visited[w] = true;
        if(w == t) {
            found = true;
            return;
        }
        for(int j=0; j<adj[w].size(); j++) {
            int p = adj[w].get(j);
            if(!visited[p]) {
                prev[p] = w;
                recurDfs(p, t, visited, prev);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        //g.bfs(0, 6);
        g.dfs(0, 7);
    }
}

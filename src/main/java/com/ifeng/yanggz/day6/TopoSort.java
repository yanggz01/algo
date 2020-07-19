package com.ifeng.yanggz.day6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1、拓扑排序算法
 * 2、深度优先算法
 *
 * 1-->3-->2-->5
 * 3-->6-->4
 * 0-->7
 */
public class TopoSort {

    private int v;
    private LinkedList<Integer>[] adj;

    public TopoSort(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    /**
     * 深度优先遍历
     */
    public void topoSortDFS() {
        // 构建逆邻接表
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        // 申请空间
        for(int k=0; k<v; k++) {
            inverseAdj[k] = new LinkedList<>();
        }
        for(int i=0; i<v; i++) {
            for(int j=0; j<adj[i].size(); j++) {
                int p = adj[i].get(j);
                inverseAdj[p].add(i);
            }
        }

        boolean[] visited = new boolean[v];
        // 深度优先遍历
        for(int j=0; j<v; j++) {
            if(visited[j] == false) {
                visited[j] = true;
                recurDFS(j, inverseAdj, visited);
            }
        }
    }

    private void recurDFS(int w, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for(int i=0; i<inverseAdj[w].size(); i++) {
            int p = inverseAdj[w].get(i);
            if(visited[p]) {
                continue;
            }
            visited[p] = true;
            recurDFS(p, inverseAdj, visited);
        }
        System.out.print("-->" + w);
    }

    /**
     * apn算法
     */
    public void topoSortKapn() {
        int[] inDegree = new int[v];
        for(int i=0; i<v; i++) {
            for(int j=0; j<adj[i].size(); j++) {
                int p = adj[i].get(j);
                inDegree[p]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<v; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();
            System.out.print("-->" + q);
            for(int j=0; j<adj[q].size(); j++) {
                int w = adj[q].get(j);
                inDegree[w]--;
                if(inDegree[w] == 0) {
                    queue.add(w);
                }
            }
        }
    }



    public static void main(String[] args) {
        TopoSort graph = new TopoSort(8);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(6, 4);
        graph.addEdge(0, 7);
        //graph.topoSortKapn();
        graph.topoSortDFS();
    }
}

package com.ifeng.yanggz.day7;

/**
 * 最短路径问题
 *
 * 1、状态转移表法
 * 2、状态转移方程法
 */
public class MinDist {

    /**
     * 状态转移表法
     *
     * @param matrix
     * @param n
     * @return
     */
    public int minDistDP(int matrix[][], int n) {
        int[][] states = new int[n][n];
        // 初始化第一行
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += matrix[0][i];
            states[0][i] = sum;
        }
        // 初始化第一列
        sum = 0;
        for(int j=0; j<n; j++) {
            sum += matrix[j][0];
            states[j][0] = sum;
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                states[i][j] = matrix[i][j] + Math.min(states[i-1][j], states[i][j-1]);
            }
        }
        return states[n-1][n-1];
    }

    /**
     * 状态转移方程
     *
     * @param matrix
     * @param mem
     * @param i
     * @param j
     * @return
     */
    public int minDist(int matrix[][], int mem[][], int i, int j) {

        if(i == 0 && j == 0) {
            return matrix[0][0];
        }
        if(mem[i][j] > 0) {
            return mem[i][j];
        }

        int minLeft = Integer.MAX_VALUE;
        if(j-1 >= 0) {
            minLeft = minDist(matrix, mem, i, j-1);
        }

        int minRight = Integer.MAX_VALUE;
        if(i-1 >= 0) {
            minRight = minDist(matrix, mem, i-1, j);
        }

        int currentMin = matrix[i][j] + Math.min(minLeft, minRight);
        mem[i][j] = currentMin;

        return currentMin;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        int[][] mem = new int[4][4];

        MinDist minDist = new MinDist();
        int min = minDist.minDist(matrix, mem, 3, 3);
        System.out.println(min);
    }
}

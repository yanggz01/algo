package com.ifeng.yanggz.day7;

/**
 * 杨辉三角动态规划问题
 *
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        int[][] matrix = {{5},{7,8},{2,3,4},{4,9,6,1},{2,7,9,4,5}};
        int r = pascalsTriangle(matrix, 5);
        System.out.println(r);
    }


    public static int pascalsTriangle(int[][] triangle, int n) {

        int[][] states = new int[n][n];

        states[0][0] = triangle[0][0];
        for(int i=1; i<n; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(j==0) {
                    states[i][j] = states[i-1][j] + triangle[i][j];
                } else if(j==triangle[i].length-1) {
                    states[i][j] = states[i-1][j-1] + triangle[i][j];
                } else {
                    states[i][j] = triangle[i][j]+Math.min(states[i-1][j-1], states[i-1][j]);
                }
            }
        }

        int minValue = Integer.MAX_VALUE;
        for(int j=0; j<states[n-1].length; j++) {
            if(states[n-1][j] < minValue) {
                minValue = states[n-1][j];
            }
        }

        return minValue;
    }
}

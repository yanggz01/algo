package com.ifeng.yanggz.day7;

/**
 * 0-1背包问题升级版(引入物品价值)
 *
 * 动态规划求背包最大价值
 *
 */
public class Knapsack2 {

    public static int knapsack2(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<=w; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if(weight[0] < w) {
            states[0][weight[0]] = value[0];
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=w; j++) {// 不放
                if(states[i-1][j] > 0) {
                    states[i][j] = states[i-1][j];
                }
            }

            for(int j=0; j<=w-weight[i]; j++) {
                if(states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if(v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }

        int maxValue = -1;
        int j;
        for(j=0; j<=w; j++) {
            if(states[n-1][j] > maxValue) {
                maxValue = states[n-1][j];
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] weight = {3,5,7,12,4};
        int[] value = {2,6,9,3,11};
        int maxValue = knapsack2(weight, value, 5, 25);
        System.out.println(maxValue);
    }
}

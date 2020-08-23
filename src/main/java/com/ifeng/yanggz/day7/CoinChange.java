package com.ifeng.yanggz.day7;

/**
 * 硬币找零问题
 *
 * 动态规划
 *
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(9));
    }

    /**
     * 状态转移表法
     *
     * @param m
     * @return
     */
    public static int coinChange(int m) {
        boolean[][] states = new boolean[m][m+1];
        if(m == 1 || m == 3 || m == 5) {
            return 1;
        }
        if(m >= 1) {
            states[0][1] = true;
        }
        if(m >= 3) {
            states[0][3] = true;
        }
        if(m >= 5) {
            states[0][5] = true;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<=m; j++) {
                if(states[i-1][j] = true) {
                    if(j+5 <=m) {
                        states[i][j+5] = true;
                    }
                    if(j+3<=m) {
                        states[i][j+3] = true;
                    }
                    if(j+2<=m) {
                        states[i][j+1] = true;
                    }
                    if(states[i][m] == true) {
                        return i;
                    }
                }
            }
        }

        return m;
    }
}

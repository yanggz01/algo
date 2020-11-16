package com.ifeng.yanggz.day7;

/**
 * 硬币找零问题
 *
 * 总共需要找零w元，有1,3,5,9四类面值的零钱，求找零的组合使零钱的张数最少
 *
 * 动态规划
 *
 */
public class CoinChange {

    public static void main(String[] args) {
        //System.out.println(coinChange(9));
        int[] coins = {1,3,5,9};
        int w = 11;
        int r = coinChange2(coins, coins.length, w);
        System.out.println();
        System.out.println(r);
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
                    if(j+5<=m) {
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

    /**
     * 状态转移表法2
     *
     * @param coin
     * @param w
     * @return
     */
    public static int coinChange2(int[] coin, int n, int w) {

        int[][] states = new int[n][w+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<=w; j++) {

                if(j == 0) {
                    states[i][j] = 0;
                    continue;
                }
                if(i == 0) {
                    states[i][j] = j/coin[i];
                } else {
                    if(j >= coin[i]) {
                        states[i][j] = Math.min(states[i-1][j], 1+states[i][j-coin[i]]);
                    } else {
                        states[i][j] = states[i-1][j];
                    }
                }
            }
        }
        // find value
        findValue2(coin, n, states, w);
        return states[n-1][w];
    }

    /**
     * 找出硬币组合V2
     *
     * @param coin
     * @param n
     * @param states
     * @param w
     */
    public static void findValue2(int[] coin, int n, int[][] states, int w) {

        for(int i=n-1,j=w; i>=0 && j>0;) {
            if(states[i][j] != states[i-1][j]) {
                System.out.print(coin[i] + " ");
                j = j-coin[i];
            } else {
                i--;
            }
        }
    }

    /**
     * 找出硬币的组合V1
     *
     * @param coin
     * @param states
     * @param w
     */
    private static void findValue(int[] coin, int n, int[][] states, int w) {
        int i = n-1;
        int j = w;
        while (i > 0 && j > 0) {
            if(states[i][j] != states[i-1][j]) {
                break;
            } else {
                i--;
            }
        }
        while (i >= 0 && j > 0) {
            System.out.print(coin[i] + " ");
            j = j-coin[i];
            if(j <= 0) {
                break;
            }
            if(i > 0) {
                while (states[i][j] == states[i-1][j]) {
                    i--;
                    if(i == 0) {
                        break;
                    }
                }
            }
        }
    }
}

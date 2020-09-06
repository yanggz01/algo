package com.ifeng.yanggz.day7;

/**
 * 0/1背包问题
 *
 * 回溯
 * 动态规划
 *
 */
public class Knapsack {

    public int maxW = Integer.MIN_VALUE;// 最大重量上限

    /**
     * 回溯
     *
     * @param i
     * @param cw
     * @param items
     * @param n
     * @param w
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        if(i == n || cw == w) {
            if(cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i+1, cw, items, n, w);// 不放i个
        if(cw+items[i] <= w) {
            f(i+1, cw+items[i], items, n, w);
        }
    }

    /**
     * 动态规划
     *
     * @param items
     * @param n
     * @param w
     * @return
     */
    public int knapsack(int[] items, int n, int w) {

        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        if(items[0] <= w) {
            states[0][items[0]] = true;
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=w; j++) {// 不放
                if(states[i-1][j] == true) {
                    states[i][j] = states[i-1][j];
                }
            }
            for(int j=0; j<=w-items[i]; j++) {// 放
                if(states[i-1][j] == true) {
                    states[i][j+items[i]] = true;
                }
            }
        }

        int r = 0;
        for(int k=w; k>=0; k--) {
            if(states[n-1][k] == true) {
                r = k;
                break;
            }
        }

        int j = r;
        for(int i=n-1; i>0; i--) {
            if(j-items[i] >=0 && states[i-1][j-items[i]]==true) {
                System.out.print(items[i] + " ");
                j = j-items[i];
            }
        }

        if(j > 0) {
            System.out.println(items[0]);
        }

        return r;
    }




    public static void main(String[] args) {
        int[] a = {5, 5, 5, 5, 11, 5, 5, 88, 23, 17};
        Knapsack knapsack = new Knapsack();
        //knapsack.f(0, 0, a, 10, 100);
        int max = knapsack.knapsack(a, 10, 100);

        System.out.println("maxW:" + max);
    }
}

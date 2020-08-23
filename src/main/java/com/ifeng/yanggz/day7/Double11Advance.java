package com.ifeng.yanggz.day7;

/**
 * 双11满减薅羊毛问题
 *
 * 动态规划问题
 *
 *
 */
public class Double11Advance {

    /**
     *
     * @param items
     * @param n
     * @param w 成本可以 >= 3*w
     */
    public void double11Advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3*w+1];
        states[0][0] = true;
        if(items[0] <= 3*w) {
            states[0][items[0]] = true;
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=3*w; j++) {// 不放
                if(states[i-1][j] == true) {
                    states[i][j] = states[i-1][j];
                }
            }
            for(int j=0; j<=3*w-items[n-1]; j++) {
                if(states[i-1][j] == true) {
                    states[i][j+items[i]] = true;
                }
            }
        }

        int j;
        for(j=0; j<3*w+1; j++) {
            if(states[n-1][j] == true) {
                break;
            }
        }

        if(j == 3*w+1) {
            return;
        }

        for(int i=n-1; i>=1; i--) {
            if(j-items[i] > 0 && states[i-1][j-items[i]]==true) {
                System.out.print(items[i] + " ");
                j = j - items[i];
            }
        }

        if(j != 0) {
            System.out.println(items[0]);
        }
    }
}

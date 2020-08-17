package com.ifeng.yanggz.day7;

/**
 * 计算莱文斯坦距离
 *
 * 动态规划
 *
 */
public class Lwst {

    public static void main(String[] args) {
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();
        Lwst lwst = new Lwst();
        int result = lwst.lwstDP(a, a.length, b, b.length);
        System.out.println(result);
    }

    /**
     * 动态规划
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int lwstDP(char[] a, int n, char[] b, int m) {

        int[][] minDist = new int[n][m];

        // 初始化第一行
        for(int i=0; i<m; i++) {
            if(a[0] == b[i]) {
                minDist[0][i] = i;
            } else if(i != 0) {
                minDist[0][i] = minDist[0][i-1]+1;
            } else {
                minDist[0][i] = 1;
            }
        }

        // 初始化第一列
        for(int j=0; j<n; j++) {
            if(a[j] == b[0]) {
                minDist[j][0] = j;
            } else if(j != 0) {
                minDist[j][0] = minDist[j-1][0] + 1;
            } else {
                minDist[j][0] = 1;
            }
        }

        // 按表填写
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(a[i] == b[j]) {
                    minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]);
                } else {
                    minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1);
                }
            }
        }


        return minDist[n-1][m-1];
    }

    public int min(int a, int b, int c) {
        int min = Integer.MAX_VALUE;
        if(a < min) {
            min = a;
        }
        if(b < min) {
            min = b;
        }
        if(c < min) {
            min = c;
        }
        return min;
    }
}

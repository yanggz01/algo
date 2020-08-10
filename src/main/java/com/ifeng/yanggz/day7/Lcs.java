package com.ifeng.yanggz.day7;

/**
 * 最长公共子串
 *
 */
public class Lcs {

    public static void main(String[] args) {
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();
        Lcs lcs = new Lcs();
        int result = lcs.lcs(a, 6, b, 6);
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
    public int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxLcs = new int[n][m];
        // 初始化第一行
        for(int i=0; i<m; i++) {
            if(a[0] == b[i]) {
                maxLcs[0][i] = 1;
            } else if(i != 0) {
                maxLcs[0][i] = maxLcs[0][i-1];
            } else {
                maxLcs[0][i] = 0;
            }
        }

        // 初始化第一列
        for(int j=0; j<n; j++) {
            if(b[0] == a[j]) {
                maxLcs[j][0] = 1;
            } else if(j != 0) {
                maxLcs[j][0] = maxLcs[j-1][0];
            } else {
                maxLcs[j][0] = 0;
            }
        }
        // 填表
        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                if(a[i] ==  b[j]) {
                    maxLcs[i][j] = max(maxLcs[i-1][j], maxLcs[i][j-1], maxLcs[i-1][j-1]+1);
                } else {
                    maxLcs[i][j] = max(maxLcs[i-1][j], maxLcs[i][j-1], maxLcs[i-1][j-1]);
                }
            }
        }
        return maxLcs[n-1][m-1];
    }

    public int max(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        if(a > max) {
            max = a;
        }
        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }

        return max;
    }
}

package com.ifeng.yanggz.day7;

/**
 * 0/1背包问题
 */
public class Knapsack {

    public int maxW = Integer.MIN_VALUE;// 最大重量上限

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

    public static void main(String[] args) {
        int[] a = {5, 5, 5, 5, 11, 5, 5, 88, 23, 17};
        Knapsack knapsack = new Knapsack();
        knapsack.f(0, 0, a, 10, 100);
        System.out.println("maxW:" + knapsack.maxW);
    }
}

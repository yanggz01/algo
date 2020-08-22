package com.ifeng.yanggz.day7;

/**
 * 求连续子数组的最大和
 * 动态规划
 */
public class Msa {

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(msa(a, a.length));
    }

    /**
     * O(n2)
     * @param a
     * @param n
     * @return
     */
    public static int msa(int[] a, int n) {
        int max = Integer.MIN_VALUE;
        int sum;
        for(int i=0; i<n; i++) {
            sum = 0;
            for(int j=i; j<n; j++) {
                sum += a[j];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划
     *
     * @param a
     * @param n
     * @return
     */
    public static int maxSubArray(int[] a, int n) {
        int[] currentSumSofar = new int[n];
        int[] maxSum = new int[n];
        currentSumSofar[0] = a[0];
        maxSum[0] = a[0];
        for(int i=1; i<n; i++) {
            currentSumSofar[i] = Math.max(currentSumSofar[i-1]+a[i], a[i]);
            maxSum[i] = Math.max(maxSum[i-1], currentSumSofar[i]);
        }
        return maxSum[n-1];
    }
}

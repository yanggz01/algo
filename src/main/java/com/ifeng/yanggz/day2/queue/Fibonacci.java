package com.ifeng.yanggz.day2.queue;

public class Fibonacci {

    public static void main(String[] args) {
        int ret = fibonacci(9);
        System.out.println(ret);
    }

    public static int fibonacci(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

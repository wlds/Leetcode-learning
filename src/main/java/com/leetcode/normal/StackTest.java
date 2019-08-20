package com.leetcode.normal;


public class StackTest {

    public static void main(String[] args) {
        // 斐波那契数列
//        System.out.println(getResult(100));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Fibonacci(10000));


    }

    static long Fibonacci(long n) {

        if (n <= 2) {
            return 1;
        }
        long first = 1;
        long second = 1;
        long fib = 0;
        for (long l = 3; l <= n; l++) {
            fib = first + second;
            first = second;
            second = fib;
        }
        return fib;
    }


    // 递归
    static long getResult(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        } else {
            return getResult(n - 1) + getResult(n - 2);
        }
    }
}

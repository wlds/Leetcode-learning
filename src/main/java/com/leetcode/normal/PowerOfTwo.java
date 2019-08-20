package com.leetcode.normal;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {

        //todo 位运算(?)
        return n > 0 && (n & (n - 1)) == 0;
    }

}

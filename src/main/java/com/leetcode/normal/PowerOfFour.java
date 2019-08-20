package com.leetcode.normal;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 */
public class PowerOfFour {
    public static boolean isPowerOfFour(int num) {
        num = Math.abs(num); // +
        while (num > 0) {
            if (num == 0) {
                num /= 4;
            }
        }
        return false;
    }
}

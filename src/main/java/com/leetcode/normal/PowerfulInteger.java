package com.leetcode.normal;

import java.util.*;

/**
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 * <p>
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 * <p>
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 */
public class PowerfulInteger {

//    HashSet<Integer> set = new HashSet<Integer>();
//
//    int i = 0;
//        while(true){
//        if(Math.pow(x, i) >= bound) break;
//        int j = 0;
//        while(true){
//            int a = (int)(Math.pow(x, i) + Math.pow(y, j++));
//            if(a > bound) break;
//            if(!set.contains(a)){
//                set.add(a);
//            }
//            if(y == 1) break;
//        }
//        if(x == 1) break;
//        i++;
//    }
//
//        return new ArrayList<Integer>(set);

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 40; i++) {
            double pow1 = Math.pow(x, i);
            for (int j = 0; j < 40; j++) {
                double pow2 = Math.pow(y, j);
                if (pow1 + pow2 <= bound) {
                    int pow = (int) (pow1 + pow2);
                    set.add(pow);
                }
            }
        }
        return new ArrayList<>(set);
    }

}



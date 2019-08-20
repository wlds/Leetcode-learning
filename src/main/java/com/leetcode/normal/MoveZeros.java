package com.leetcode.normal;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeros {

    //leetcode 答案
    public static void moveZeroes(int[] nums) {
        // [0,1,0,3,12]
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++; // 记录0的个数  ---> 2
            } else {
                nums[i - count] = nums[i]; // 数组中不为0的数依次排列  ---> [1,3,12,3,12]
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) { // 通过记录的值 替换末尾值为0
            nums[i] = 0;
        }

    }
}

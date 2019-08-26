package com.leetcode.sort;

import java.util.*;

/**
 * 两个数组的交集
 */
public class Intersection {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     * 说明:
     * <p>
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        // Map 判断 （空间换时间）,Set 去重

        Map<Integer, Integer> maps = new HashMap<>();
        Set<Integer> sets = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            int i1 = nums1[i];
            maps.put(i1, 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            int i2 = nums2[i];
            Integer orDefault = maps.getOrDefault(i2, 2);
            if (orDefault == 1) {
                sets.add(i2);
            }
        }

        int[] result = new int[sets.size()];

        int k = 0;
        for (Integer set : sets) {
            result[k++] = set;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = intersection(nums1, nums2);

        for (int i : intersection) {
            System.out.println(i);
        }
    }
}

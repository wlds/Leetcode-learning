package com.leetcode.greedyalgorithm;

import java.util.Arrays;

/**
 * 最后一块石头的重量
 */
public class LastStone {

    /**
     * 有一堆石头，每块石头的重量都是正整数。
     * <p>
     * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * <p>
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/last-stone-weight
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路：
     * <p>
     * 只有一个石头即返回，
     * 先排序，判断次大是否为0，为0则返回 最大快
     * 对最大和次大进行粉碎操作，粉碎后重新排序
     */
    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        Arrays.sort(stones);

        while (stones[stones.length - 2] != 0) {

            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }

        return stones[stones.length - 1];
    }

    public static void main(String[] args) {
        int[] stones = {7, 3, 2, 4, 1};
        int i = lastStoneWeight(stones);

        System.out.println(i);
    }
}

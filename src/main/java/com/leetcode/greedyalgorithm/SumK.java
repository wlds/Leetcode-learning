package com.leetcode.greedyalgorithm;

import java.util.Arrays;

/**
 * . K 次取反后最大化的数组和
 */
public class SumK {

    /**
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
     * <p>
     * 以这种方式修改数组后，返回数组可能的最大和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [4,2,3], K = 1
     * 输出：5
     * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
     * 示例 2：
     * <p>
     * 输入：A = [3,-1,0,2], K = 3
     * 输出：6
     * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
     * 示例 3：
     * <p>
     * 输入：A = [2,-3,-1,5,-4], K = 2
     * 输出：13
     * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 10000
     * 1 <= K <= 10000
     * -100 <= A[i] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路：
     * 中心思想：排序
     * <p>
     * 根据注释代码，可知，只需要将每次反转后的数组排序取最小值即可
     * <p>
     * 优化后即：    先将 K次以内的负数和0进行反转。如果 K 大于负数反转的次数，只需要判断 剩余次数K的奇偶性即可。
     */
    public static int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        int minus = 0;
        int a = K;
        Arrays.sort(A); //遍历
        for (int i = 0; i < A.length; i++) {    // 获取所有负数反转
            if (A[i] <= 0) {
                A[i] *= -1;
                minus++;
                K--;
                if (K == 0) {   // 反转次数为0
                    break;
                }
            }
        }
        if (a >= minus) {
            Arrays.sort(A);
            //反转最小值
            if (K % 2 == 1) {
                A[0] *= -1;
            }
        }
        for (int i : A) {
            sum += i;
        }
        return sum;
    }


//    public int largestSumAfterKNegations(int[] A, int K) {
//        int sum = 0;
//
//        for (int i : A) {
//            Arrays.sort(A);
//
//            A[0] *= -1;
//            K--;
//            if (K == 0) {
//                break;
//            }
//        }
//        for (int i : A) {
//            sum += i;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
//        int[] A = {-10, -27, -24, -25, -5, -26, -7, 20, -11, 11, 1, 9, 26, 28, 1, -6, 26, -28, 7, -3, 26, -16, 26, 26, -27, -5, -15, 27, 29, 20, -23, -29, -12, 0, 27, 15, -7, -22, 8, 7, 16, -24, 16, -10, 10, 1, 24, -17, -8, 5, -7, 14, 24, -2, -7, -7, 4, -7, -3, 21, 19, 11, 11, -30, -7, 25, -9, -30, -15, -21, 22, 29, 24, 24, -21, -12, 20, 21, -28, 24, -14, -19, 0, 10, 25, 15, 4, 28, -23, -16, 4, -27, 7, 11, -4, 18, -15, -19, 17, -7};
        int[] A = {-4, -6, 9, -2, 2};
//        int i = largestSumAfterKNegations(A, 38);
        int i = largestSumAfterKNegations(A, 4);
        System.out.println(i);
    }
}

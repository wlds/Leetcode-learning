package com.leetcode.sort;

import java.util.Arrays;

/**
 * 有效的字母异位词
 */
public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * <p>
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");

        System.out.println(anagram);

    }

    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 冒泡排序
     */
    private static String toSort(String str) {

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {    // 遍历次数 最后一位不需要比较 为 length-1 次

            for (int j = 0; j < chars.length - 1 - i; j++) {    // 从第1位开始，大的则换位，则最大值为 第 (length-1)位 可排除(length-1)位的比较
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }


}

package com.leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EffectiveBrackets {


    /**
     * 思路
     *  将所有左括号进栈，对右括号进行匹配
     */
    private static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

            if (aChar == '(' || aChar == '{' || aChar == '[') { //左括号进栈
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop(); // 堆顶弹栈
                if (pop == '(' && aChar == ')' || pop == '{' && aChar == '}' || pop == '[' && aChar == ']') {
                    continue;
                } else {
                    return false;
                }
            }


        }
        return stack.empty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("({{{{[][][]}}}})"));
    }
}

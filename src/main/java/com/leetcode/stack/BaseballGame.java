package com.leetcode.stack;

import java.util.Stack;

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * <p>
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 示例 2:
 * <p>
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * <p>
 * 注意：
 * <p>
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BaseballGame {

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        long l = System.currentTimeMillis();
        int i = calPoints(ops);
        long l1 = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(l1 - l);
    }

    public static int calPoints(String[] ops) {

        Stack<Integer> data = new Stack<>();

        for (String op : ops) {
            switch (op) {
                case "C": { //表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
                    if (!data.isEmpty()) {
                        data.pop();
                    }
                    break;
                }
                case "D": { //表示本轮获得的得分是前一轮有效 回合得分的两倍。
                    if (!data.isEmpty()) {
                        data.push(data.peek() * 2);
                    }
                    break;
                }
                case "+": { //表示本轮获得的得分是前两轮有效 回合得分的总和。
                    int lastNum = data.pop();   // 前一轮
                    int lastNum2 = data.peek(); // 前二轮
                    data.push(lastNum);
                    data.push(lastNum + lastNum2);  // 本轮
                    break;
                }
                default:
                    data.push(new Integer(op));
            }


        }
        int result = 0;
        while (!data.isEmpty()) {
            result += data.pop();
        }
        return result;
    }


//    public static int calPoints(String[] ops) {
//
//        Stack<String> data = new Stack<>();
//
//        int result = 0;
//        for (String op : ops) {
//
//            switch (op) {
//                case "C": { //表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
//                    if (!data.isEmpty()) {
//                        Integer pop = new Integer(data.pop());
//                        result -= pop;
//                    }
//                    break;
//                }
//                case "D": { //表示本轮获得的得分是前一轮有效 回合得分的两倍。
//                    if (!data.isEmpty()) {
//                        Integer peek = new Integer(data.peek());
//                        data.push(peek * 2 + "");
//                        result += (peek * 2);
//                    }
//                    break;
//                }
//                case "+": { //表示本轮获得的得分是前两轮有效 回合得分的总和。
//                    int lastNum = new Integer(data.pop());
//                    int l2 = new Integer(data.peek());
//                    data.push(lastNum + "");
//                    data.push(lastNum + l2 + "");
//                    result += (lastNum + l2);
//                    break;
//                }
//                default:
//                    data.push(op);
//                    result += new Integer(op);
//            }
//
//
//        }
//        return result;
//    }
}

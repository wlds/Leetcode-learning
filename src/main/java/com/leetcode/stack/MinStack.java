package com.leetcode.stack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    Stack<Integer> data;
    Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() >= x) {   // helper为空以及 data栈顶元素大于插入元素时， helper插入该元素
            helper.push(x);
        } else { // helper插入当前自己最小值元素,保持与data同步
            helper.push(helper.peek());
        }
        System.out.println("data  :" + data);
        System.out.println("helper:" + helper);
    }

    public void pop() {
        if (!data.empty()) {
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if (!data.empty()) {
            return data.peek();
        }
        throw new RuntimeException("栈元素为空，非法操作");
    }

    public int getMin() {
        if (!helper.empty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈元素为空，非法操作");
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.push(8);
        obj.push(9);
        obj.push(10);
        obj.pop();
        int param_1 = obj.top();
        int param_2 = obj.getMin();
        System.out.println("top: " + param_1);
        System.out.println("min: " + param_2);

        System.out.println("-------------分割线------------------");

        MinStackNoAuto obj2 = new MinStackNoAuto();
        obj2.push(11);
        obj2.push(12);
        obj2.push(13);
        obj2.push(14);
        obj2.push(15);
        obj2.push(16);
        obj2.push(17);
        obj2.push(18);
        obj2.push(19);
        obj2.push(20);
        obj2.pop();
        int param_3 = obj2.top();
        int param_4 = obj2.getMin();
        System.out.println("top: " + param_3);
        System.out.println("min: " + param_4);
    }
}


/**
 * 辅助栈不同步解法
 */
class MinStackNoAuto {

    Stack<Integer> data;
    Stack<Integer> helper;

    public MinStackNoAuto() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() >= x) {   // helper为空以及 data栈顶元素大于插入元素时， helper插入该元素
            helper.push(x);
        }
        System.out.println("data  :" + data);
        System.out.println("helper:" + helper);
    }

    public void pop() {
        if (!data.empty()) {
            int pop = data.pop();
            if (pop == helper.peek()) {
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.empty()) {
            return data.peek();
        }
        throw new RuntimeException("栈元素为空，非法操作");
    }

    public int getMin() {
        if (!helper.empty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈元素为空，非法操作");
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
package 栈;

import java.util.Stack;

/**
 * @author joyeYang
 * @date 2020-04-13 16:21
 *
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 *
 */
public class TM_09_用两个栈实现队列 {
    /**
     * 一个专门负责入队，一个专门负责出队
     * 入队直接添加
     * 出队需要判断是否为空
     */

    Stack<Integer> inStack =  new Stack<>();
    Stack<Integer> outStack = new Stack<>();

//    public Queue() {
//        inStack = new Stack<>();
//        outStack = new Stack<>();
//    }

    public void enQueue(int x) {
        inStack.push(x);
    }

    public int deQueue() {
        if (inStack.isEmpty() && outStack.isEmpty()) return -1;
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

class Queue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public Queue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enQueue(int x) {
        inStack.push(x);
    }

    public int deQueue() {
        if (inStack.isEmpty() && outStack.isEmpty()) return -1;
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

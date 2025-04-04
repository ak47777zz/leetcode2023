package leetcode6.leetcode.editor.cn;

import java.util.Stack;

/**
 * 232:用栈实现队列
 */
public class 用栈实现队列232 {
    public static void main(String[] args) {
        Solution solution = new 用栈实现队列232().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        private Stack<Integer> stackA;
        private Stack<Integer> stackB;

        public MyQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void push(int x) {
            stackA.push(x);
        }

        public int pop() {
            if (!stackB.isEmpty()) {
                return stackB.pop();
            }
            move();
            return stackB.pop();
        }

        public int peek() {
            if (!stackB.isEmpty()) {
                return stackB.peek();
            }
            move();
            return stackB.peek();
        }

        public boolean empty() {
            return stackA.isEmpty() && stackB.isEmpty();
        }

        private void move() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
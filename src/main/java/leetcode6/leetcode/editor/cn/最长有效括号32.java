package leetcode6.leetcode.editor.cn;

import java.util.Stack;

/**
 * 32:最长有效括号
 */
public class 最长有效括号32 {
    public static void main(String[] args) {
         Solution solution = new 最长有效括号32().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
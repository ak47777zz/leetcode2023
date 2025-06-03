//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics栈 | 字符串 | 动态规划 
//
// 👍 2713, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode7.leetcode.editor.cn;

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
            Stack<Integer> stack = new Stack<>();
            // 最后一个没有被匹配的右括号的下标
            // 放一个-1占位
            stack.push(-1);
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else {
                    // 右括号，弹出栈顶
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        // 更新最大长度
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
            return res;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
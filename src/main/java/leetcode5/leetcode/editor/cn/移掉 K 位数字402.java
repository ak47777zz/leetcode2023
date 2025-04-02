//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
//
// Related Topics栈 | 贪心 | 字符串 | 单调栈 
//
// 👍 1109, 👎 0 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 402:移掉 K 位数字
 */
public class 移掉 K 位数字402 {
    public static void main(String[] args) {
        Solution solution = new 移掉 K 位数字402 ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 作者：笨猪爆破组
        // 单调栈
        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            for (char c : num.toCharArray()) {
                while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                    stack.pop();
                    k--;
                }
                if (c == '0' && stack.isEmpty()) {
                    continue;
                }
                stack.push(c);
            }

            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

            StringBuffer buffer = new StringBuffer();
            while(!stack.isEmpty()){
                buffer.append(stack.pop());
            }

            return buffer.length() == 0 ? "0" : buffer.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
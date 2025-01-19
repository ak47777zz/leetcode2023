//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3749, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 22:括号生成
 */
public class 括号生成22 {
    public static void main(String[] args) {
        Solution solution = new 括号生成22().new Solution();
        solution.generateParenthesis(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法1：自创的全排解组合 + 判断是否为有效括号
        // 方法2：liweiwei 深度优先遍历，判断还剩余多少可用括号，当剩余左括号>剩余右括号时剪枝
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            dfs("",n, n, res);
            return res;
        }

        private void dfs(String s , int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(s);
                return;
            }

            // 当剩余左括号>剩余右括号时剪枝
            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(s + "(", left - 1, right, res);
            }

            if (right > 0) {
                dfs(s + ")", left, right - 1, res);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
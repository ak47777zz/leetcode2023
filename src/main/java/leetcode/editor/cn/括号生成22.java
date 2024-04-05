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
// 👍 3548, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 22:括号生成
 */
public class 括号生成22 {
    public static void main(String[] args) {
        Solution solution = new 括号生成22().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            dfs("", n, n, res);
            return res;
        }

        /**
         *
         * @param generate 生产的字符串
         * @param left 左括号还有几个可用
         * @param right 右括号还有几个可用
         * @param res 结果集
         */
        private void dfs(String generate, int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(generate);
                return;
            }

            // 左括号可用数量大于有括号,违规
            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(generate + "(", left - 1, right, res);
            }
            if (right > 0) {
                dfs(generate + ")", left, right - 1, res);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
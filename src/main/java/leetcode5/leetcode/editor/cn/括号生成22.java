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
// 👍 3796, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

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
            backTracing(n, n, "", res);
            return res;
        }

        private void backTracing(int leftNum, int rightNum, String s, List<String> res) {
            if (leftNum == 0 && rightNum == 0) {
                res.add(s);
                return;
            }

            if (leftNum > rightNum) {
                return;
            }

            if (leftNum > 0) {
                backTracing(leftNum - 1, rightNum, s + "(", res);
            }
            if (rightNum > 0) {
                backTracing(leftNum, rightNum - 1, s + ")", res);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
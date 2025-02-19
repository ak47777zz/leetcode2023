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
// 👍 3768, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

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

        List<String> res;

        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            backTracking("", n, n);
            return res;
        }

        private void backTracking(String path, int leftNum, int rightNum) {
            if (leftNum == 0 && rightNum == 0) {
                res.add(path);
                return;
            }

            // 左括号数量大于右括号数量，直接剪枝
            if (leftNum > rightNum) {
                return;
            }

            // 使用一个左括号
            if (leftNum > 0) {
                backTracking(path + "(", leftNum - 1, rightNum);
            }

            // 使用一个右括号
            if (rightNum > 0) {
                backTracking(path + ")", leftNum, rightNum - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
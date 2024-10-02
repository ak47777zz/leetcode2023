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
// 👍 3690, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22:括号生成
 */
public class 括号生成22 {
    public static void main(String[] args) {
        Solution solution = new 括号生成22().new Solution();
        //solution.isValid(Lists.newArrayList("(","(","(",")",")",")"));
        solution.generateParenthesis(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> symbol = new ArrayList<>();
            symbol.add("(");
            symbol.add(")");

            List<String> res = new ArrayList<>();

            backTracking(n, 0, new ArrayList<>(), res, symbol);
            return res;
        }

        private void backTracking(int n, int deep, List<String> path, List<String> res, List<String> symbol) {
            if (deep == 2*n ) {
                if (isValid(path)) {
                    res.add(toString(path));
                }
                return;
            }

            for (int i = 0; i < symbol.size(); i++) {
                path.add(symbol.get(i));
                backTracking(n, deep + 1, path, res, symbol);
                path.remove(path.size() - 1);
            }

        }

        private boolean isValid(List<String> path) {
            Stack<String> leftStack = new Stack<>();
            leftStack.addAll(path);
            Stack<String> rightStack = new Stack<>();
            while (!leftStack.isEmpty()) {
                String item = leftStack.pop();
                if (")".equals(item)) {
                    rightStack.push(item);
                }
                if ("(".equals(item)) {
                    if (rightStack.isEmpty()) {
                        return false;
                    }
                    rightStack.pop();
                }
            }
            return rightStack.isEmpty();

        }

        public String toString(List<String> path) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
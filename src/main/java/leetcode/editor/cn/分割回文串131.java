//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 1767, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 131:分割回文串
 */
public class 分割回文串131 {
    public static void main(String[] args) {
        Solution solution = new 分割回文串131().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            int len = s.length();
            if (len == 0) {
                return res;
            }
            char[] charArray = s.toCharArray();
            Stack<String> stack = new Stack<>();
            dfs(charArray, 0, len, stack, res);
            return res;
        }

        /**
         * @param charArray 给定的字符串
         * @param index     起始字符的索引
         * @param len       字符串长度
         * @param path      保存遍历的路径
         * @param res       结果
         */
        private void dfs(char[] charArray, int index, int len, Stack<String> path, List<List<String>> res) {
            if (index == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 截取字符串
            for (int i = index; i < len; i++) {
                if (!isHuiWen(charArray, index, i)) {
                    continue;
                }
                path.push(new String(charArray, index, i + 1 - index));
                dfs(charArray, i + 1, len, path, res);
                path.pop();
            }
        }

        private boolean isHuiWen(char[] charArray, int left, int right) {
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
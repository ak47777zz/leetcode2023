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
// 👍 1865, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 131:分割回文串
 */
public class 分割回文串131 {
    public static void main(String[] args) {
        Solution solution = new 分割回文串131().new Solution();
        solution.partition("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            backTracking(s, 0, new ArrayList<>(), res);
            return res;
        }

        private void backTracking(String s, int startIndex, List<String> path, List<List<String>> res) {
            if (startIndex >= s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i < s.length() ; i++) {
                String str = s.substring(startIndex, i + 1);
                if (isBackStr(str)) {
                    path.add(str);
                    backTracking(s, i + 1, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isBackStr(String str) {
            char[] charArray = str.toCharArray();
            int left = 0;
            int right = str.length() - 1;
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
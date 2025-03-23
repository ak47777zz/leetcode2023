//给你一个字符串 s，找到 s 中最长的 回文 子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics双指针 | 字符串 | 动态规划 
//
// 👍 7580, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

/**
 * 5:最长回文子串
 */
public class 最长回文子串5 {
    public static void main(String[] args) {
        Solution solution = new 最长回文子串5().new Solution();
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String str;
                // 奇数
                str = maxLength(s, i, i);
                res = str.length() > res.length() ? str : res;
                // 偶数
                str = maxLength(s, i, i + 1);
                res = str.length() > res.length() ? str : res;
            }
            return res;
        }

        private String maxLength(String s, int left, int right) {
            String res = "";
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res = s.substring(left, right + 1);
                left--;
                right++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
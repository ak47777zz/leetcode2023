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
// 👍 7526, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

/**
 * 5:最长回文子串
 */
public class 最长回文子串5 {
    public static void main(String[] args) {
        Solution solution = new 最长回文子串5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";

            // 每个字符进行中心扩散法
            for (int i = 0; i < s.length(); i++) {
                // 当前字符为奇数的最长回文串
                String s1 = longestPalindrome(s, i, i);
                res = s1.length() > res.length() ? s1 : res;

                // 当前字符为偶数的最长回文串
                String s2 = longestPalindrome(s, i, i + 1);
                res = s2.length() > res.length() ? s2 : res;
            }
            return res;
        }

        private String longestPalindrome(String s, int left, int right) {
            String res = "";
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                res = s.substring(left, right + 1);
                left--;
                right++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
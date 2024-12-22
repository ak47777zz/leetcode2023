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
// 👍 7412, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

/**
 * 5:最长回文子串
 */
public class 最长回文子串5 {
    public static void main(String[] args) {
        Solution solution = new 最长回文子串5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 代码随想录 中心扩散法
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 奇数的回文子串
                String s1 = diffuse(s, i, i);
                res = s1.length() > res.length() ? s1 : res;
                // 偶数的回文子串
                String s2 = diffuse(s, i, i+1);
                res = s2.length() > res.length() ? s2 : res;
            }
            return res;
        }

        // 返回最长的回文子串
        private String diffuse(String s, int left, int right) {
            String tmp = "";
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                tmp = s.substring(left, right + 1);
                left--;
                right++;
            }
            return tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
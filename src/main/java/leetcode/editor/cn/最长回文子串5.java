//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
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
// 👍 7189, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 5:最长回文子串
 */
public class 最长回文子串5 {
    public static void main(String[] args) {
        Solution solution = new 最长回文子串5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 中心扩散法 作者(liweiwei)
        public String longestPalindrome(String s) {

            int length = s.length();
            if (length < 2) {
                return s;
            }

            int[] max = new int[] {0, 0};

            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length - 1; i++) {
                // 奇数回文字符串
                int[] odd = centerSpread(s, i, i);
                // 偶数回文字符串
                int[] even = centerSpread(s, i, i + 1);

                int[] res = odd[1] > even[1] ? odd : even;
                if (res[1] > max[1]) {
                    max = res;
                }
            }
            return s.substring(max[0], max[0] + max[1]);
        }

        // 数组第一位是起始点,第二位是回文字符串长度
        public int[] centerSpread(String s, int left, int right) {
            int len = s.length();
            // 边界控制
            while (left >= 0 && right < len) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            return new int[] {left + 1, right - left - 1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
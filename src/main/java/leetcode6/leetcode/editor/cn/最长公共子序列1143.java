package leetcode6.leetcode.editor.cn;

/**
 * 1143:最长公共子序列
 */
public class 最长公共子序列1143 {
    public static void main(String[] args) {
        Solution solution = new 最长公共子序列1143().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
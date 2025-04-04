package leetcode6.leetcode.editor.cn;

/**
 * 72:编辑距离
 */
public class 编辑距离72 {
    public static void main(String[] args) {
         Solution solution = new 编辑距离72().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        // 初始化第一行
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        // 初始化第一列
        for (int i = 1; i <= word1.length() ; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <=word2.length() ; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
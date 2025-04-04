package leetcode6.leetcode.editor.cn;

/**
 * 221:最大正方形
 */
public class 最大正方形221 {
    public static void main(String[] args) {
        Solution solution = new 最大正方形221().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            int maxSide = 0;
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
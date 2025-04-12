package leetcode6.leetcode.editor.cn;
  
/**
 * 62:不同路径
 */
public class 不同路径62 {
    public static void main(String[] args) {
         Solution solution = new 不同路径62().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 初始化第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
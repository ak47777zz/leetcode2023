//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics数组 | 动态规划 | 矩阵 
//
// 👍 1768, 👎 0 
//
//
//
//

package leetcode5.leetcode.editor.cn;

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
            if (matrix == null) {
                return 0;
            }

            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            int maxSide = 0;
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <=matrix[0].length ; j++) {
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

// backup

// base condition
//            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {return 0;}
//
//    int height = matrix.length;
//    int width = matrix[0].length;
//    int maxSide = 0;
//
//    // 相当于已经预处理新增第一行、第一列均为0
//    int[][] dp = new int[height + 1][width + 1];
//
//    for (int row = 1; row <= height; row++) {
//    for (int col = 1; col <= width; col++) {
//    if (matrix[row - 1][col - 1] == '1') {
//    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
//    maxSide = Math.max(maxSide, dp[row][col]);
//    }
//    }
//    }
//    return maxSide * maxSide;
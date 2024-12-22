//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics广度优先搜索 | 数学 | 动态规划 
//
// 👍 2053, 👎 0 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 279:完全平方数
 */
public class 完全平方数279 {
    public static void main(String[] args) {
        Solution solution = new 完全平方数279().new Solution();
        solution.numSquares(12);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            // dp[i]定义:和为i的完全平方数为dp[i]
            for (int i = 1; i <= n; i++) { // 容量
                for (int j = 1; j * j <= i; j++) { // 物品
                    if (i >= j * j) {
                        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    }
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
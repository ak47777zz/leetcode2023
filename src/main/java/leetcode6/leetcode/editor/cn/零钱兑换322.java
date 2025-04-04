package leetcode6.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 322:零钱兑换
 */
public class 零钱兑换322 {
    public static void main(String[] args) {
        Solution solution = new 零钱兑换322().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }

            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
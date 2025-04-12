package leetcode6.leetcode.editor.cn;
  
/**
 * 70:爬楼梯
 */
public class 爬楼梯70 {
    public static void main(String[] args) {
         Solution solution = new 爬楼梯70().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
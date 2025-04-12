package leetcode6.leetcode.editor.cn;
  
/**
 * 122:买卖股票的最佳时机 II
 */
public class 买卖股票的最佳时机 II122 {
    public static void main(String[] args) {
         Solution solution = new 买卖股票的最佳时机 II122().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                res = res + temp;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 2225, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 152:乘积最大子数组
 */
public class 乘积最大子数组152 {
    public static void main(String[] args) {
        Solution solution = new 乘积最大子数组152().new Solution();
        solution.maxProduct(new int[] {-2, 3, -4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 作者 -> liweiwei1419
        public int maxProduct(int[] nums) {
            // dp[i] 表示以nums[i]结尾的最大值和最小值
            // dp[i] = Max(dp[i-1]*nums[i],nums[i])
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            // 第二维 -> 0表示最大值，1表示最小值
            int[][] dp = new int[length][2];
            dp[0][1] = nums[0];
            dp[0][0] = nums[0];
            for (int i = 1; i < length; i++) {
                // 正数
                if (nums[i] >= 0) {
                    dp[i][1] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                    dp[i][0] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
                } else {
                    // 负数
                    dp[i][1] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                    dp[i][0] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
                }
            }

            int max = dp[0][1];
            for (int i = 1; i < length; i++) {
                max = Math.max(max, dp[i][1]);
            }
            return max;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
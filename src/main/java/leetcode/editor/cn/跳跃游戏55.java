//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics贪心 | 数组 | 动态规划 
//
// 👍 2723, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 55:跳跃游戏
 */
public class 跳跃游戏55 {
    public static void main(String[] args) {
        Solution solution = new 跳跃游戏55().new Solution();
        solution.canJump(new int[] {2, 3, 1, 1, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 官方
        // 位置i可到达的最远距离 = 之前维护的最远可到达距离和i + nums[i]的最大值
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int len = nums.length;
            int jumpMost = 0;
            for (int i = 0; i < len; i++) {
                if (i <= jumpMost) {
                    jumpMost = Math.max(jumpMost, i + nums[i]);
                }
                if (jumpMost >= len - 1) {
                    return true;
                }
            }
            return false;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
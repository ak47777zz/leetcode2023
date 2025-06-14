//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 5719, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode7.leetcode.editor.cn;

/**
 * 42:接雨水
 */
public class 接雨水42 {
    public static void main(String[] args) {
        Solution solution = new 接雨水42().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int[] leftMaxArray = new int[height.length];
            int leftMax = 0;
            for (int i = 0; i < height.length; i++) {
                leftMax = Math.max(leftMax, height[i]);
                leftMaxArray[i] = leftMax;
            }

            int[] rightMaxArray = new int[height.length];
            int rightMax = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                rightMax = Math.max(rightMax, height[i]);
                rightMaxArray[i] = rightMax;
            }

            int result = 0;
            for (int i = 0; i < height.length; i++) {
                int res = Math.min(leftMaxArray[i],rightMaxArray[i]) - height[i];
                result = result + res;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
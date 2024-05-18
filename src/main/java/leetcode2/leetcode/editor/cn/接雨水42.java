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
// 👍 5160, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.Stack;

/**
 * 42:接雨水
 */
public class 接雨水42 {
    public static void main(String[] args) {
        Solution solution = new 接雨水42().new Solution();
        solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 灵茶山艾府的视频，讲的非常好
        public int trap(int[] height) {
            // 构建每个节点左边的最大值
            int[] leftMax = new int[height.length];
            for (int i = 0; i < height.length; i++) {
                if (i == 0) {
                    leftMax[i] = height[i];
                    continue;
                }
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            // 构建每个节点右边的最大值
            int[] rightMax = new int[height.length];
            for (int i = height.length - 1; i >=0; i--) {
                if (i == height.length - 1) {
                    rightMax[i] = height[i];
                    continue;
                }
                rightMax[i] = Math.max(rightMax[i+1], height[i]);
            }

            int res = 0;
            for (int i = 0; i < height.length; i++) {
                Integer left = leftMax[i];
                Integer right = rightMax[i];
                res += Math.min(left, right) - height[i];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
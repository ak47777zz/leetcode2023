//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics数组 | 前缀和 
//
// 👍 1926, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

/**
 * 238:除自身以外数组的乘积
 */
public class 除自身以外数组的乘积238 {
    public static void main(String[] args) {
        Solution solution = new 除自身以外数组的乘积238().new Solution();
        solution.productExceptSelf(new int[] {1, 2, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 当前元素左边的乘积
            int[] left = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                left[i] = i == 0 ? 1 : left[i - 1] * nums[i - 1];
            }
            // 当前元素右边的乘积
            int[] right = new int[nums.length];
            for (int i = nums.length -1 ; i >=0  ; i--) {
                right[i] = i == nums.length - 1 ? 1 : right[i + 1] * nums[i+1];
            }

            // 结果计算
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = left[i] * right[i];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
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
// 👍 1609, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 238:除自身以外数组的乘积
 */
public class 除自身以外数组的乘积238 {
    public static void main(String[] args) {
        Solution solution = new 除自身以外数组的乘积238().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 左右乘积列表
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            // nums[i]左侧乘积
            int[] L = new int[length];
            // nums[i]右侧乘积
            int[] R = new int[length];

            // 第一位的左侧没有乘积
            L[0] = 1;
            for (int i = 1; i < length; i++) {
                L[i] = L[i - 1] * nums[i - 1];
            }

            // 最后一位的右侧没有乘积
            R[length - 1] = 1;
            for (int i = length-2 ; i >=0 ; i--) {
                R[i] = R[i + 1] * nums[i + 1];
            }

            int[] answer = new int[length];
            for (int i = 0; i < length; i++) {
                answer[i] = L[i] * R[i];
            }
            return answer;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
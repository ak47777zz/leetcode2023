//峰值元素是指其值严格大于左右相邻值的元素。
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 1372, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

/**
 * 162:寻找峰值
 */
public class 寻找峰值162 {
    public static void main(String[] args) {
        Solution solution = new 寻找峰值162().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 作者:宫水三叶
        public int findPeakElement(int[] nums) {
            // 一次遍历
            for (int i = 0; i < nums.length; i++) {
                boolean flag = true;
                // 判断左边
                if (i - 1 >= 0) {
                    if (nums[i - 1] > nums[i]) {
                        flag = false;
                    }
                }

                // 判断右边
                if (i + 1 < nums.length) {
                    if (nums[i] < nums[i + 1]) {
                        flag = false;
                    }
                }

                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics数组 | 二分查找 | 前缀和 | 滑动窗口 
//
// 👍 2406, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

/**
 * 209:长度最小的子数组
 */
public class 长度最小的子数组209 {
    public static void main(String[] args) {
        Solution solution = new 长度最小的子数组209().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 作者: 数据结构和算法 ，方法二
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
            while (right <= nums.length - 1) {
                // 加入一个元素
                sum = sum + nums[right];
                right++;
                // 判断结果是否大于等于 target
                while (sum >= target) {
                    min = Math.min(min, right - left);
                    sum = sum - nums[left];
                    left++;
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
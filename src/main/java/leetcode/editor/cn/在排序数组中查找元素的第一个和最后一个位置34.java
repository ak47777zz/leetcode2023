//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2664, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 34:在排序数组中查找元素的第一个和最后一个位置
 */
public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public static void main(String[] args) {
        Solution solution = new 在排序数组中查找元素的第一个和最后一个位置34().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //寻找左边界(这里寻找第一个 >= target的索引)
            int leftIdx = search(nums, target);
            //寻找右边界(这里寻找第一个 >= target的索引)
            int rightIdx = search(nums, target + 1);
            rightIdx = rightIdx - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[] {leftIdx, rightIdx};
            }
            return new int[] {-1, -1};
        }

        // 寻找第一个>=目标值的索引, 找不到则返回数组长度
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = left + 1;
                }
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
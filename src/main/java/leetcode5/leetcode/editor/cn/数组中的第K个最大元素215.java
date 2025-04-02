//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 2671, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

/**
 * 215:数组中的第K个最大元素
 */
public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {
        Solution solution = new 数组中的第K个最大元素215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 第 1 大的数，下标是 len - 1;
            // 第 2 大的数，下标是 len - 2;
            // ...
            // 第 k 大的数，下标是 len - k;
            int len = nums.length;
            int target = len - k;

            int left = 0;
            int right = len - 1;

            while (true) {
                int pivotIndex = pivotIndex(nums, left, right);
                if (pivotIndex == target) {
                    return nums[pivotIndex];
                } else if (pivotIndex < target) {
                    left = pivotIndex + 1;
                } else {
                    // pivotIndex > target
                    right = pivotIndex - 1;
                }
            }
        }

        private int pivotIndex(int[] nums, int left, int right) {
            int pivot = nums[left];
            int i = left;
            // 把小于pivot值的元素都交换到左边来
            for (int j = left + 1; j <= right; j++) {
                if (nums[j] <= pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, left, i);
            return i;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }


}
//leetcode submit region end(Prohibit modification and deletion)

  }
//给你一个整数数组 nums，请你将该数组升序排列。
//
// 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics数组 | 分治 | 桶排序 | 计数排序 | 基数排序 | 排序 | 堆（优先队列） | 归并排序 
//
// 👍 1096, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

/**
 * 912:排序数组
 */
public class 排序数组912 {
    public static void main(String[] args) {
        Solution solution = new 排序数组912().new Solution();
        solution.sortArray(new int[] {5, 2, 3, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            sortArray(nums, 0, nums.length - 1);
            return nums;
        }

        private void sortArray(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivotIndex = pivotIndex(nums, left, right);
            sortArray(nums, left, pivotIndex - 1);
            sortArray(nums, pivotIndex + 1, right);
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
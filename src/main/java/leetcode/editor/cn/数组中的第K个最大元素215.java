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
// 👍 2452, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.Random;

/**
 * 215:数组中的第K个最大元素
 */
public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {
        Solution solution = new 数组中的第K个最大元素215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final static Random random = new Random(System.currentTimeMillis());

        // 使用快排的思想,快排partition就是把某个数放在它正确的位置上
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
                int pivotIndex = partition(nums, left, right);
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

        public int partition(int[] nums, int left, int right) {
            // 可以随机取pivot，性能更佳
            int pivotIndex = left + random.nextInt(right - left + 1);
            swap(nums, left, pivotIndex);

            int pivot = nums[left];

            // nums[left ... i) 小于等于pivot
            int i = left + 1;

            // nums(j ... right) 大于等于pivot
            int j = right;

            while (true) {
                // 左边找到第一个大于等于pivot的数
                while (i <= j && nums[i] < pivot) {
                    i++;
                }
                // 右边找到第一个小于等于pivot的数
                while (i <= j && nums[j] > pivot) {
                    j--;
                }

                // 两种情况
                // 1. j = i , 当前位置的值就是pivot，可以直接退出
                // 2. j < i , 当前已经整理到边界了，可以跳出
                if (j <= i) {
                    break;
                }
                swap(nums, i, j);
                i++;
                j--;
            }

            // 最后一次交换,把最左边的pivot，交互到j的位置上
            swap(nums, left, j);
            return j;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
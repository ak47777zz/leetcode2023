//给你一个整数数组 nums，请你将该数组升序排列。
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
// 👍 989, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.Random;

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

        Random random = new Random();

        // 双路快排
        // https://www.bilibili.com/video/BV1jB4y117GJ/?spm_id_from=333.788&vd_source=59cabb2bef774a4a1049ba1357ebc931
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
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
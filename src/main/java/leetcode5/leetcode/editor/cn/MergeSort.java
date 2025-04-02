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
// 👍 1097, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 归并排序
 * https://www.cnblogs.com/kenwan/p/18357555
 */
public class MergeSort {
    public static void main(String[] args) {
        Solution solution = new MergeSort().new Solution();
        int[] nums = new int[] {1, 5, 2, 4};
        solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] arr) {
            int[] temp = new int[arr.length];
            sortHelper(arr, 0, arr.length - 1, temp);
            return arr;
        }

        private void sortHelper(int[] arr, int left, int right, int[] temp) {
            // 无需归并
            if (left >= right) {
                return;
            }
            int mid = (left + right) / 2;
            sortHelper(arr, left, mid, temp);
            sortHelper(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

        private void merge(int[] arr, int left, int mid, int right, int[] temp) {
            int i = left;
            int j = mid + 1;

            int idx = left;

            while (i <= mid || j <= right) {
                if (i > mid) {
                    temp[idx] = arr[j];
                    j++;
                } else if (j > right) {
                    temp[idx] = arr[i];
                    i++;
                } else {
                    if (arr[i] <= arr[j]) {
                        temp[idx] = arr[i];
                        i++;
                    } else {
                        temp[idx] = arr[j];
                        j++;
                    }
                }
                idx++;
            }

            for (int k = left; k <= right; k++) {
                arr[k] = temp[k];
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
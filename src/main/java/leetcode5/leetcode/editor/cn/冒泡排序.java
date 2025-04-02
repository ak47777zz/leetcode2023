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

package leetcode5.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 912:排序数组
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        Solution solution = new 冒泡排序().new Solution();
        int[] nums = new int[] {1, 5, 2, 4};
        solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            // 外层控制循环次数
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
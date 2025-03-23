//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 7352, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15:三数之和
 */
public class 三数之和15 {
    public static void main(String[] args) {
        Solution solution = new 三数之和15().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }

            // 排序后方便去重
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                // 当前元素跟前一个元素相等，直接去重跳过
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 如果当前元素大于0,后面一定没有办法找到三元组和为 0
                if (nums[i] > 0) {
                    break;
                }

                // 双指针遍历
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        // 收集到一组结果
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 左指针移动并去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 右指针移动并去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // 再移动一位
                        left++;
                        right--;

                    } else if (sum > 0) {
                        // 总和要缩小
                        right--;
                    } else {
                        // 总和要增加
                        left++;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
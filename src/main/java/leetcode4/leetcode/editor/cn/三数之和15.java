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
// 👍 7268, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15:三数之和
 */
public class 三数之和15 {
    public static void main(String[] args) {
        Solution solution = new 三数之和15().new Solution();
        solution.threeSum(new int[] {0, 0, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 排序后方便后面去重
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                // 跟前一个数相同则直接跳过
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 当前数字大于0，后面不可能凑齐结果等于0的三元组
                if (nums[i] > 0) {
                    break;
                }

                int left = i + 1 ;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        // 搜集到一组，写入结果
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        // 左指针移动到下一个值不重复的点
                        while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // 右指针移动到下一个值不重复的点
                        while (right > 0 && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // 再移动一位
                        left++;
                        right--;

                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
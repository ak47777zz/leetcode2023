//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
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
// 👍 6407, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15:三数之和
 */
public class 三数之和15 {
    public static void main(String[] args) {
        Solution solution = new 三数之和15().new Solution();
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双循坏 + 双指针
        public List<List<Integer>> threeSum(int[] nums) {
            // 数组排序后,双循环查找
            Arrays.sort(nums);
            int length = nums.length;

            List<List<Integer>> result = new ArrayList<>();
            for (int first = 0; first < length; first++) {
                // 每次找数字不同的
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                int target = -nums[first];
                int third = length - 1;

                for (int second = first + 1; second < length; second++) {
                    // 每次找数字不同的
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }

                    // 两个指针值相加大于target,右指针左移使target总数减少
                    while (second < third && nums[second] + nums[third] > target) {
                        third--;
                    }

                    // 指针相同了就不可能找到了,结束掉
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        result.add(list);
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)



}
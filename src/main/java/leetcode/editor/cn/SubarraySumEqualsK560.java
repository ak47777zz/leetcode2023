//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 2104, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 560:和为 K 的子数组
 */
public class SubarraySumEqualsK560 {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK560().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 哈希 + 前缀和
            HashMap<Integer/*preSum*/, Integer/*count*/> map = new HashMap<>();
            // 如果需要0时，自己就可以成为子数组
            map.put(0, 1);
            int preSum = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum = preSum + nums[i];
                if (map.containsKey(preSum - k)) {
                    count = count + map.get(preSum - k);
                }
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
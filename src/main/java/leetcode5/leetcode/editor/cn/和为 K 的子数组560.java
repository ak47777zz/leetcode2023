//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
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
// 👍 2683, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 560:和为 K 的子数组
 */
public class 和为 K 的子数组560 {
    public static void main(String[] args) {
        Solution solution = new 和为 K 的子数组560 ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 前缀和思路
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int res = 0;
            int preSum = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum = preSum + nums[i];
                int need = preSum - k;
                if (map.containsKey(need)) {
                    res = res + map.get(need);
                }
                Integer count = map.getOrDefault(preSum, 0);
                count++;
                map.put(preSum, count);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
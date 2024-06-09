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
// 👍 2355, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

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
        // 哈希 + 前缀和
        public int subarraySum(int[] nums, int k) {
            Map<Integer/*前缀和*/, Integer/*出现次数*/> map = new HashMap<>();

            // 当前need为0时,说明这个前缀和已经满足k的条件了,直接算一次结果
            map.put(0, 1);

            int pre = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int preSum = pre + nums[i];
                int need = preSum - k;
                // 前缀和map中存在need,结果中加入这个前缀和出现的次数
                if (map.containsKey(need)) {
                    res += map.get(need);
                }
                // 更新前缀和
                Integer count = map.getOrDefault(preSum, 0);
                map.put(preSum, count + 1);
                pre = preSum;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



    //
    //HashMap<Integer/*前缀和*/, Integer/*出现次数*/> map = new HashMap<>();
    //        map.put(0, 1);
    //
    //            int pre  = 0;
    //            int res = 0;
    //            for (int i = 0; i < nums.length; i++) {
    //int preSum = pre + nums[i];
    //int need = preSum - k;
    //if (map.containsKey(need)) {
    //res = res + map.get(need);
    //}
    //Integer count = map.getOrDefault(preSum, 0);
    //map.put(preSum, count + 1);
    //pre = preSum;
    //}
    //return res;
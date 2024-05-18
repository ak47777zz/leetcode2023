//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics并查集 | 数组 | 哈希表 
//
// 👍 2085, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.HashSet;

/**
 * 128:最长连续序列
 */
public class 最长连续序列128 {
    public static void main(String[] args) {
        Solution solution = new 最长连续序列128().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双循环
        public int longestConsecutive(int[] nums) {
            // 放入hash中
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int maxLength = 0;

            // 寻找每组的首个数字
            for (int num : nums) {
                // 存在比当前数字小1的数字，不是这组的首位
                if (set.contains(num - 1)) {
                    continue;
                }
                // 统计这组的最大长度是多少
                int length = 1;
                while (set.contains(num + 1)) {
                    length++;
                    num++;
                }
                maxLength = Math.max(maxLength, length);
            }
            return maxLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
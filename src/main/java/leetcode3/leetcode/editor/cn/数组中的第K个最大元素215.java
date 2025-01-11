//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 2609, 👎 0 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 215:数组中的第K个最大元素
 */
public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {
        Solution solution = new 数组中的第K个最大元素215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 最小堆,把前K个最大元素放进去，队列头则为第K个最大元素
            PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    minQueue.add(nums[i]);
                } else {
                    Integer minValue = minQueue.peek();
                    if (nums[i] > minValue) {
                        minQueue.poll();
                        minQueue.add(nums[i]);
                    }
                }
            }
            return minQueue.peek();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
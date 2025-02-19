//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics队列 | 数组 | 滑动窗口 | 单调队列 | 堆（优先队列） 
//
// 👍 3003, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 239:滑动窗口最大值
 */
public class 滑动窗口最大值239 {
    public static void main(String[] args) {
        Solution solution = new 滑动窗口最大值239().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 最大堆
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            // 放入k个元素
            for (int i = 0; i < k; i++) {
                queue.add(new int[] {nums[i], i});
            }

            // 写入第一个最大值
            int[] res = new int[nums.length - k + 1];
            res[0] = queue.peek()[0];

            // 计算后边最大值
            int index = k;
            while (index <= nums.length - 1) {
                // 放入当前值
                queue.add(new int[] {nums[index], index});
                // 当前最大值如果不在k区间内，则移除
                while (queue.peek()[1] < index - k + 1) {
                    queue.poll();
                }
                res[index - k + 1] = queue.peek()[0];
                index++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
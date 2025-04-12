package leetcode6.leetcode.editor.cn;

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
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int i = 0; i < k; i++) {
                queue.add(new int[] {nums[i], i});
            }

            // 先放入第一个元素
            int[] res = new int[nums.length - k + 1];
            res[0] = queue.peek()[0];

            for (int i = k; i < nums.length; i++) {
                // 当前元素加入
                queue.add(new int[] {nums[i], i});
                while (queue.peek()[1] < i - k + 1) {
                    queue.poll();
                }
                res[i - k + 1] = queue.peek()[0];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
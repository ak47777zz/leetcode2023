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
// 👍 2564, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.Comparator;
  import java.util.PriorityQueue;

  /**
   * 239:滑动窗口最大值
   */
  public class 滑动窗口最大值239 {
      public static void main(String[] args) {
           Solution solution = new 滑动窗口最大值239().new Solution();
          int[] nums = new int[] {1,-1};
          solution.maxSlidingWindow(nums, 1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 优先队列
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 数组下标0为数值,下标1为数组中的位置
                return o2[0] - o1[0];
            }
        });

        int[] res = new int[nums.length - k + 1];
        // 初始化前面k个
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new int[] {nums[i], i});
        }
        res[0] = priorityQueue.peek()[0];

        for (int i = k; i < nums.length; i++) {
            priorityQueue.add(new int[] {nums[i], i});
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            res[i - k + 1] = priorityQueue.peek()[0];
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
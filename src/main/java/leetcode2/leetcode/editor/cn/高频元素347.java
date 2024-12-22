//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics数组 | 哈希表 | 分治 | 桶排序 | 计数 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 1898, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347:前 K 个高频元素
 */
public class 高频元素347 {
    public static void main(String[] args) {
        Solution solution = new 高频元素347 ().new Solution();
        solution.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 卡子哥
        public int[] topKFrequent(int[] nums, int k) {
            // 1.先用遍历一遍，用map存在每个数字出现的次数
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                Integer count = countMap.getOrDefault(num, 0);
                countMap.put(num, ++count);
            }
            // 2.使用最小堆，堆顶是当前最小值，遍历一遍，每次新增元素都将堆顶元素移除，剩下的K个元素就是高频元素
            // 初始化最小堆
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // 正序排列,是最小值在堆顶
                    return countMap.get(o1) - countMap.get(o2);
                }
            });

            for (Integer num : countMap.keySet()) {
                Integer count = countMap.get(num);
                // 堆未满，直接插入堆尾
                if (queue.size() < k) {
                    queue.add(num);
                } else {
                    // 堆已满，判断当前元素是否大于堆顶元素
                    if (count > countMap.get(queue.peek())) {
                        queue.poll();
                        queue.add(num);
                    }
                }
            }

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll();
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
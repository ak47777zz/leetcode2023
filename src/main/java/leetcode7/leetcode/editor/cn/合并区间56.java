//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics数组 | 排序 
//
// 👍 2577, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode7.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 56:合并区间
 */
public class 合并区间56 {
    public static void main(String[] args) {
        Solution solution = new 合并区间56().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            for (int[] interval : intervals) {
                queue.add(interval);
            }

            List<int[]> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] lastArray = res.isEmpty() ? null : res.get(res.size() - 1);
                int[] curArray = queue.poll();
                // 单独成为一组
                if (lastArray == null || curArray[0] > lastArray[1]) {
                    res.add(curArray);
                } else {
                    lastArray[1] = Math.max(lastArray[1], curArray[1]);
                }
            }

            int[][] result = new int[res.size()][2];
            for (int i = 0; i < res.size(); i++) {
                result[i] = res.get(i);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
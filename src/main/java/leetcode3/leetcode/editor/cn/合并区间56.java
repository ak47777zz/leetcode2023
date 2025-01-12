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
// 👍 2484, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56:合并区间
 */
public class 合并区间56 {
    public static void main(String[] args) {
        Solution solution = new 合并区间56().new Solution();
        int[][] intervals = new int[3][2];
        intervals[0] = new int[] {1, 4};
        intervals[1] = new int[] {0, 2};
        intervals[2] = new int[] {3, 5};
        //intervals[3] = new int[] {15, 18};
        solution.merge(intervals);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 1. 先按左边元素对数组做个排序
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            // 2.循环处理
            List<int[]> res = new ArrayList<>();

            // 3.第一组先放进去
            res.add(intervals[0]);

            // 4.从第二组开始循环处理
            for (int i = 1; i < intervals.length; i++) {
                // 当前组
                int[] cur = intervals[i];
                // 上一组
                int[] last = res.get(res.size() - 1);

                // 如果当前组左元素大于上一组右元素，则新增一组
                if (cur[0] > last[1]) {
                    res.add(cur);
                } else {
                    // 当前组左元素小于等于上一组右元素，与上一组合并
                    last[1] = Math.max(last[1], cur[1]);
                }
            }

            // 5.结果转换
            int[][] result = new int[res.size()][2];
            for (int i = 0; i < res.size(); i++) {
                result[i] = res.get(i);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
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
// 👍 2343, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 56:合并区间
 */
public class 合并区间56 {
    public static void main(String[] args) {
        Solution solution = new 合并区间56().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // liweiwei的方法
        // 数组按左边正排，然后遍历合并有交集的区间
        public int[][] merge(int[][] intervals) {
            // 按照每行左边元素正排
            Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

            // 先放入一组
            LinkedList<int[]> list = new LinkedList<>();
            list.add(intervals[0]);

            for (int i = 1; i < intervals.length; i++) {
                int[] last = list.getLast();
                int[] interval = intervals[i];
                // 如果新的一组左边界大于上一组右边界,则新增一组
                if (interval[0] > last[1]) {
                    list.addLast(interval);
                } else {
                    // 否则新的一组左边界小于等于上一组右边界,则右边界改为新的一组右边界 与 现在取最大值
                    last[1] = Math.max(last[1],interval[1]) ;
                }
            }

            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
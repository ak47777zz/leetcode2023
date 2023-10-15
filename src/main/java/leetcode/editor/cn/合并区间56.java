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
// 👍 2133, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.Arrays;
  import java.util.Comparator;
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
    public int[][] merge(int[][] intervals) {
        // 按每个数组左侧正排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 记录范围,第一个元素塞入
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 判断下个数组左边界是否小于之前记录的右边界
            if (intervals[i][0] <= result.getLast()[1]) {
                // 更新记录右边界
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            } else {
                // 无交集,直接加入
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[0][0]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
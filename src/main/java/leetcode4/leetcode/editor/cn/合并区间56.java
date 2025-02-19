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
// 👍 2508, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode4.leetcode.editor.cn;

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
        // 使用优先级队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }

        // 结果集
        List<List<Integer>> res = new ArrayList<>();

        // 先放入第一个区间
        int[] min = queue.poll();
        List<Integer> first = new ArrayList<>();
        first.add(min[0]);
        first.add(min[1]);
        res.add(first);

        // 处理后面的区间
        for (int i = 1; i < intervals.length; i++) {
            // 当前区间
            int[] range = queue.poll();
            // 上一个区间
            List<Integer> last = res.get(res.size() - 1);
            // 如果当前区间左值小于等于上一个区间右值，则合并
            if (range[0] <= last.get(1)) {
                last.set(1, Math.max(last.get(1), range[1]));
            } else {
                // 单独成一个区间
                List<Integer> list = new ArrayList<>();
                list.add(range[0]);
                list.add(range[1]);
                res.add(list);
            }
        }

        // 转化为数组
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            int[] array = new int[] {list.get(0), list.get(1)};
            result[i] = array;
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
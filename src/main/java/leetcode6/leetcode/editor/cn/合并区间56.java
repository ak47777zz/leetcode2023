package leetcode6.leetcode.editor.cn;

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
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for (int[] interval : intervals) {
            queue.add(interval);
        }

        // 先加入第一个区间
        List<int[]> res = new ArrayList<>();
        res.add(queue.poll());

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int[] last = res.get(res.size() - 1);
            // 合并
            if (cur[0] <= last[1]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                // 新增
                res.add(cur);
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
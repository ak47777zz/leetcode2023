//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 
//
// 👍 1935, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207:课程表
 */
public class 课程表207 {
    public static void main(String[] args) {
        Solution solution = new 课程表207().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // BFS 作者(K神)
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 课程入度
            int[] indegrees = new int[numCourses];
            // 课程出度
            List<List<Integer>> adjacency = new ArrayList<>();

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }

            // 构建课程出度和入度关系
            for (int[] cp : prerequisites) {
                indegrees[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }

            // 将所有入度为0的加入queue中
            for (int i = 0; i < numCourses; i++) {
                if (indegrees[i] == 0) {queue.add(i);}
            }

            // 遍历queue
            while (!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for (int cur : adjacency.get(pre)) {
                    // 课程入度-1
                    indegrees[cur]--;
                    // 减完后如果入度为0,则加入queue中
                    if (indegrees[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }
            return numCourses == 0;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
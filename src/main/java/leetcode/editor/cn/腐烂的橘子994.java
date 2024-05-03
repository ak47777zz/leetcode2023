//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics广度优先搜索 | 数组 | 矩阵 
//
// 👍 837, 👎 0 
//
//
//
//

package leetcode.editor.cn;

/**
 * 994:腐烂的橘子
 */
public class 腐烂的橘子994 {
    public static void main(String[] args) {
        Solution solution = new 腐烂的橘子994().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 作者(。)的方法，dfs很容易理解，直接在图上更新传播过来的时间，最后最大值-2
        public int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        dfs(grid, i, j, 2);
                    }
                }
            }

            // 全部遍历寻找最大值
            int maxTime = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                    maxTime = Math.max(maxTime, grid[i][j]);
                }
            }
            return maxTime == 0 ? 0 : maxTime - 2;

        }

        public void dfs(int[][] grid, int i, int j, int time) {
            // 判断是否在网格中
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }

            // 判断是否需要更新time
            // 不是新鲜橘子并且时间小于当前时间
            if (grid[i][j] != 1 && grid[i][j] < time) {
                return;
            }
            grid[i][j] = time;
            dfs(grid, i - 1, j, time + 1);
            dfs(grid, i + 1, j, time + 1);
            dfs(grid, i, j + 1, time + 1);
            dfs(grid, i, j - 1, time + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
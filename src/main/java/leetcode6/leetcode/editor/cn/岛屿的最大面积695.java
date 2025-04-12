package leetcode6.leetcode.editor.cn;

/**
 * 695:岛屿的最大面积
 */
public class 岛屿的最大面积695 {
    public static void main(String[] args) {
        Solution solution = new 岛屿的最大面积695().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
                return 0;
            }

            grid[i][j] = 0;
            int num = 1;
            num += dfs(grid, i + 1, j);
            num += dfs(grid, i - 1, j);
            num += dfs(grid, i, j + 1);
            num += dfs(grid, i, j - 1);
            return num;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
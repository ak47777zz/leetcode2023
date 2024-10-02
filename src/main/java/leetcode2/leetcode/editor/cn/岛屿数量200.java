  //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 2588, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode2.leetcode.editor.cn;

  /**
   * 200:岛屿数量
   */
  public class 岛屿数量200 {
      public static void main(String[] args) {
           Solution solution = new 岛屿数量200().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        // 双循环岛屿淹没法
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    submerge(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

          private void submerge(int i, int j, char[][] grid) {
              if (grid[i][j] == '0') {
                  return;
              }
              // 淹没此岛屿
              grid[i][j] = '0';

              int row = grid.length;
              int column = grid[0].length;

              // 上
              if (i - 1 >= 0) {
                  submerge(i - 1, j, grid);
              }

              // 下
              if (i + 1 < row) {
                  submerge(i + 1, j, grid);
              }

              // 左
              if (j - 1 >= 0) {
                  submerge(i, j - 1, grid);
              }

              // 右
              if (j + 1 < column) {
                  submerge(i, j + 1, grid);
              }

          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
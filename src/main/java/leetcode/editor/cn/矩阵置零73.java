  //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// Related Topics数组 | 哈希表 | 矩阵 
//
// 👍 960, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode.editor.cn;

  /**
   * 73:矩阵置零
   */
  public class 矩阵置零73 {
      public static void main(String[] args) {
           Solution solution = new 矩阵置零73().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        // 方法一: 使用数组标记0所在的行和列
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] rowMark = new boolean[row];
        boolean[] columnMark = new boolean[column];

        // 第一次循环记录0的行列位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowMark[i] = true;
                    columnMark[j] = true;
                }
            }
        }

        // 第二次循环开始修改值
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowMark[i] || columnMark[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 2.使用两个标记变量
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
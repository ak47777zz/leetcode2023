  //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1514, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  /**
   * 54:螺旋矩阵
   */
  public class 螺旋矩阵54 {
      public static void main(String[] args) {
           Solution solution = new 螺旋矩阵54().new Solution();
          int[][] matrix  = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
          solution.spiralOrder(matrix);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }
        int row = matrix.length, column = matrix[0].length;
        int left = 0, top = 0, right = column - 1, down = row - 1;

        List<Integer> result = new ArrayList<>(row * column);
        while (result.size() < row * column) {
            // 起始点，从左往右
            if (top <= down) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }

            // 从上往下
            if (left <= right) {
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }

            // 从右往左
            if (top <= down) {
                for (int i = right; i >= left ; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }

            // 从下往上
            if (left <= right) {
                for (int i = down; i >= top ; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
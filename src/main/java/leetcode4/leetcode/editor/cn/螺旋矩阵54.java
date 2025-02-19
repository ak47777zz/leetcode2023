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
// 👍 1850, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode4.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  /**
   * 54:螺旋矩阵
   */
  public class 螺旋矩阵54 {
      public static void main(String[] args) {
           Solution solution = new 螺旋矩阵54().new Solution();
          int[][] a = new int[][] {{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}};
          solution.spiralOrder(a);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;

        // 装满为止
        while (res.size() != matrix.length * matrix[0].length) {
            // 从左到右遍历
            if (up <= down) {
                for (int i = left; i <= right ; i++) {
                    res.add(matrix[up][i]);
                }
                up++;
            }

            // 从上到下遍历
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            // 从右到左遍历
            if (up <= down) {
                for (int i = right; i >= left ; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            }

            // 从下到上遍历
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
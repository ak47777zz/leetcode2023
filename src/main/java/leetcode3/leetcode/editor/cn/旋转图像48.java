//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics数组 | 数学 | 矩阵 
//
// 👍 1979, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

/**
 * 48:旋转图像
 */
public class 旋转图像48 {
    public static void main(String[] args) {
        Solution solution = new 旋转图像48().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 技巧: 先按对角线反转,再每行反转
        public void rotate(int[][] matrix) {
            // 1. 先按对角线反转
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix[0].length; j++) {
                    // 对角线不反转
                    if (i == j) {
                        continue;
                    }
                    // 反转
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }

            // 2. 再每行反转
            for (int[] row : matrix) {
                reserve(row);
            }
        }

        private void reserve(int[] row) {
            int left = 0, right = row.length - 1;
            while (left < right) {
                int tmp = row[left];
                row[left] = row[right];
                row[right] = tmp;
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
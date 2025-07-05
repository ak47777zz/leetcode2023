//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics数组 | 二分查找 | 矩阵 
//
// 👍 1054, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode7.leetcode.editor.cn;

/**
 * 74:搜索二维矩阵
 */
public class 搜索二维矩阵74 {
    public static void main(String[] args) {
        Solution solution = new 搜索二维矩阵74().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = 0;
            int column = matrix[0].length - 1;
            while (row < matrix.length && matrix[row][column] < target) {
                row++;
            }

            if (row == matrix.length) {
                return false;
            }

            int left = 0;
            int right = column;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
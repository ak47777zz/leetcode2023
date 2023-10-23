//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
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
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 | 分治 | 矩阵 
//
// 👍 1371, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 240:搜索二维矩阵 II
 */
public class 搜索二维矩阵 II240 {
    public static void main(String[] args) {
        Solution solution = new 搜索二维矩阵 II240().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 定位右上角,z字形查找法
            int row = matrix.length, column = matrix[0].length;

            int i = 0, j = column - 1;
            while (i < row && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    // 当前值小于目标值,需要数值大一点
                    i++;
                } else {
                    // 当前值大于目标值,需要数值小一点
                    // 此处必须用else,因为上面i++在最后一轮循环时,已经超出了数组的长度,如果用matrix[i][j]判断就数组越界了
                    j--;
                }

            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
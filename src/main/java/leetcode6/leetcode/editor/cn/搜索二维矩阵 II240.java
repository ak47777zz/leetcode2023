package leetcode6.leetcode.editor.cn;
  
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
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            int value = matrix[row][column];
            if (value == target) {
                return true;
            } else if (value < target) {
                row++;
            } else {
                column--;
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
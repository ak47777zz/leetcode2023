//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1144, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 118:杨辉三角
 */
public class 杨辉三角118 {
    public static void main(String[] args) {
        Solution solution = new 杨辉三角118().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 纯取数解法，找上一行对应的两个位置
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows == 0) {
                return res;
            }
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                    }
                }
                res.add(row);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
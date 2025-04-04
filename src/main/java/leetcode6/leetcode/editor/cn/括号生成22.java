package leetcode6.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 22:括号生成
 */
public class 括号生成22 {
    public static void main(String[] args) {
        Solution solution = new 括号生成22().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backTracking(res, n, n, "");
            return res;
        }

        private void backTracking(List<String> res, int leftCount, int rightCount, String s) {
            if (leftCount == 0 && rightCount == 0) {
                res.add(s);
                return;
            }

            // 左括号数量大于右括号数量
            if (leftCount > rightCount) {
                return;
            }

            if (leftCount > 0) {
                backTracking(res, leftCount - 1, rightCount, s + "(");
            }

            if (rightCount > 0) {
                backTracking(res, leftCount, rightCount - 1, s + ")");
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
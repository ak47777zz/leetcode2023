package leetcode6.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 93:复原 IP 地址
 */
public class 复原地址93 {
    public static void main(String[] args) {
        Solution solution = new 复原地址93().new Solution();
        solution.restoreIpAddresses("25525511135");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() > 12) {
                return res;
            }
            backTracking(s, 0, 0, res);
            return res;
        }

        private void backTracking(String s, int startIndex, int num, List<String> res) {
            if (num == 3) {
                if (isValid(s, startIndex, s.length() - 1)) {
                    res.add(s);
                }
                return;
            }

            for (int i = startIndex; i < s.length(); i++) {
                if (isValid(s, startIndex, i)) {
                    // 加上逗号
                    s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                    num++;
                    backTracking(s, i + 2, num, res);
                    // 减去逗号
                    num--;
                    s = s.substring(0, i + 1) + s.substring(i + 2);
                } else {
                    break;
                }
            }
        }

        private boolean isValid(String s, int left, int right) {
            if (left > right) {
                return false;
            }
            // 长度大于 1 ，开头为 0 不合法
            if (left != right && s.charAt(left) == '0') {
                return false;
            }
            String str = s.substring(left, right + 1);
            int value = Integer.parseInt(str);
            return value >= 0 && value <= 255;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
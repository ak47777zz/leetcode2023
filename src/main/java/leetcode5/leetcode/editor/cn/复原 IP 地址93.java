//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics字符串 | 回溯 
//
// 👍 1494, 👎 0 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 93:复原 IP 地址
 */
public class 复原 IP 地址93 {
    public static void main(String[] args) {
        Solution solution = new 复原 IP 地址93 ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        // 代码随想录
        public List<String> restoreIpAddresses(String s) {
            if (s.length() > 12) {
                return res;
            }
            backTracking(s, 0, 0);
            return res;
        }

        private void backTracking(String s, int startIndex, int pointNum) {
            if (pointNum == 3) {
                if (isValid(s, startIndex, s.length() - 1)) {
                    res.add(s);
                }
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isValid(s, startIndex, i)) {
                    s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                    pointNum++;
                    backTracking(s, i + 2, pointNum);
                    pointNum--;
                    s = s.substring(0, i + 1) + s.substring(i + 2);
                } else {
                    break;
                }
            }
        }

        private boolean isValid(String s, int start, int end) {
            if (start > end) {
                return false;
            }
            // 开头为 0 不合法
            if (s.charAt(start) == '0' && start != end) {
                return false;
            }
            int value = Integer.parseInt(s.substring(start, end + 1));
            return value <= 255;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 3195, 👎 0 
//
//
//
//

package leetcode5.leetcode.editor.cn;

/**
 * 76:最小覆盖子串
 */
public class 最小覆盖子串76 {
    public static void main(String[] args) {
        Solution solution = new 最小覆盖子串76().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // ascii码 128个字符够了
            int[] sArray = new int[128];
            int[] tArray = new int[128];

            // 填充 tArray
            for (int i = 0; i < t.length(); i++) {
                tArray[t.charAt(i)]++;
            }

            String res = "";
            int min = Integer.MAX_VALUE;

            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                sArray[s.charAt(right)]++;
                while (isValid(sArray, tArray)) {
                    // 最小值判断
                    if (right - left < min) {
                        min = right -left;
                        res = s.substring(left, right + 1);
                    }
                    // 左侧元素移除
                    sArray[s.charAt(left)]--;
                    left++;
                }
            }
            return res;

        }

        private boolean isValid(int[] sArray, int[] tArray) {
            for (int i = 0; i < 128; i++) {
                if (sArray[i] < tArray[i]) {
                    return false;
                }
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
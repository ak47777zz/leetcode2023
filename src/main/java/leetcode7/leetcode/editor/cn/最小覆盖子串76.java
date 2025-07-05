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
// 👍 3265, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode7.leetcode.editor.cn;

/**
 * 76:最小覆盖子串
 */
public class 最小覆盖子串76 {
    public static void main(String[] args) {
        Solution solution = new 最小覆盖子串76().new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] sArray = new int[128];
            int[] tArray = new int[128];
            for (int i = 0; i < t.length(); i++) {
                tArray[t.charAt(i)]++;
            }

            String res = "";
            int min = Integer.MAX_VALUE;

            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                // 元素加入
                sArray[s.charAt(right)]++;
                while (contains(tArray, sArray)) {
                    if (min > right - left + 1) {
                        min = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                    sArray[s.charAt(left)]--;
                    left++;
                }
            }
            return res;
        }

        // 判断当前窗口中，是否包含 t 中所有字符
        private boolean contains(int[] tArray, int[] sArray) {
            for (int i = 0; i < tArray.length; i++) {
                if (sArray[i] < tArray[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
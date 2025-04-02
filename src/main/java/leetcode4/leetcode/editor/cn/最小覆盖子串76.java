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

package leetcode4.leetcode.editor.cn;

/**
 * 76:最小覆盖子串
 */
public class 最小覆盖子串76 {
    public static void main(String[] args) {
        Solution solution = new 最小覆盖子串76().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 作者：艾神
        public String minWindow(String S, String t) {
            char[] s = S.toCharArray();
            int m = s.length;

            int min = Integer.MAX_VALUE;
            String str = "";

            int[] cntS = new int[128]; // s 子串字母的出现次数
            int[] cntT = new int[128]; // t 中字母的出现次数
            for (char c : t.toCharArray()) {
                cntT[c]++;
            }

            int left = 0;
            for (int right = 0; right < m; right++) { // 移动子串右端点
                cntS[s[right]]++; // 右端点字母移入子串
                while (isCovered(cntS, cntT)) { // 涵盖
                    if (right - left < min) {
                        min = right - left;
                        str = S.substring(left ,right +1);
                    }
                    cntS[s[left]]--; // 左端点字母移出子串
                    left++;
                }
            }
            return str;
        }

        private boolean isCovered(int[] cntS, int[] cntT) {
            for (int i = 'A'; i <= 'Z'; i++) {
                if (cntS[i] < cntT[i]) {
                    return false;
                }
            }
            for (int i = 'a'; i <= 'z'; i++) {
                if (cntS[i] < cntT[i]) {
                    return false;
                }
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
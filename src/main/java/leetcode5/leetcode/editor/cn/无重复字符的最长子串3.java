//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 10686, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import java.util.LinkedHashSet;

/**
 * 3:无重复字符的最长子串
 */
public class 无重复字符的最长子串3 {
    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串3().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            int res = 0;
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    set.add(c);
                    i++;
                } else {
                    set.remove(set.iterator().next());
                }
                res = Math.max(res, set.size());
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
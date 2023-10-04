//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
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
// 👍 9680, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.HashSet;

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
            HashSet<Character> set = new HashSet<>();

            int right = -1;
            int n = s.length();
            int maxLength = 0;
            for (int left = 0; left < n; left++) {
                // 左指针向右移动一格，移除一个字符
                if (left != 0) {
                    set.remove(s.charAt(left - 1));
                }
                while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                    // 不断地移动右指针
                    set.add(s.charAt(right + 1));
                    right++;
                }
                // 第 left 到 right 个字符是一个极长的无重复字符子串
                maxLength = Math.max(maxLength, set.size());
            }
            return maxLength;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1493, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438:找到字符串中所有字母异位词
 */
public class 找到字符串中所有字母异位词438 {
    public static void main(String[] args) {
        Solution solution = new 找到字符串中所有字母异位词438().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int sLength = s.length();
            int pLength = p.length();
            if (pLength > sLength) {
                return res;
            }

            // 字符串p的统一数组
            int[] pArray = new int[26];
            for (int i = 0; i < pLength; i++) {
                pArray[p.charAt(i) - 'a']++;
            }

            // 先把p长度的字符放入数组中
            int[] sArray = new int[26];
            for (int i = 0; i < pLength; i++) {
                sArray[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(pArray, sArray)) {
                res.add(0);
            }

            for (int i = p.length(); i < sLength; i++) {
                // 减去最左边字符
                sArray[s.charAt(i - pLength) - 'a']--;
                // 加上新增字符
                sArray[s.charAt(i) - 'a']++;
                if (Arrays.equals(pArray, sArray)) {
                    res.add(i - pLength +1 );
                }
            }
            return res;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
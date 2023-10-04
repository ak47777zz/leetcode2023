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
// 👍 1300, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

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

        // 滑动窗口
        // 因为字符串 p的异位词的长度一定与字符串 p 的长度相同，所以我们可以在字符串 s 中构造一个长度为与字符串 p 的长度相同的滑动窗口，并在滑动中维护窗口中每种字母的数量；当窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，则说明当前窗口为字符串 p 的异位词。

        public List<Integer> findAnagrams(String s, String p) {
            if (s == null || p == null) {
                return new ArrayList<>();
            }
            int pLength = p.length();
            int sLength = s.length();

            if (sLength < pLength) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<>();
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            // 初始化
            for (int i = 0; i < pLength; i++) {
                sCount[s.charAt(i) - 'a']++;
                pCount[p.charAt(i) - 'a']++;
            }

            if (Arrays.equals(sCount, pCount)) {
                result.add(0);
            }

            for (int i = 0; i < sLength - pLength; i++) {
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + pLength) - 'a']++;
                if (Arrays.equals(sCount, pCount)) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
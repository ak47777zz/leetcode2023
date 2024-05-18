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
// 👍 10127, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

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
            // 进入hash中的都是不重复的元素
            Set<Character> set = new HashSet<>();

            int res = 0;
            int length = s.length();

            // 右指针初始化为-1,兼容第1个字符
            int right = -1;
            for (int left = 0; left < length; left++) {
                // 不重复的字符放入hash中,直到找到第一个重复的元素
                while (right + 1 < length && !set.contains(s.charAt(right + 1))) {
                    set.add(s.charAt(right + 1));
                    right++;
                }
                // 此时计算最大长度
                res = Math.max(res, set.size());
                // 移除左指针字符
                set.remove(s.charAt(left));
            }
            return res;

            //// 暴力双循环试下
            //int res = 0;
            //
            //int length = s.length();
            //for (int i = 0; i < length; i++) {
            //    Set<Character> set = new HashSet<>();
            //    for (int j = i; j < length; j++) {
            //        if (!set.contains(s.charAt(j))) {
            //            set.add(s.charAt(j));
            //        } else {
            //            res = Math.max(res, set.size());
            //            break;
            //        }
            //        if (j == length - 1) {
            //            res = Math.max(res, set.size());
            //            break;
            //        }
            //    }
            //}
            //return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
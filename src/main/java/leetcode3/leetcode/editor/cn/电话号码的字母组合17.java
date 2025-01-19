//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics哈希表 | 字符串 | 回溯 
//
// 👍 2979, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17:电话号码的字母组合
 */
public class 电话号码的字母组合17 {
    public static void main(String[] args) {
        Solution solution = new 电话号码的字母组合17().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }
            Map<Character, String> phoneNum = new HashMap<>();
            phoneNum.put('2', "abc");
            phoneNum.put('3', "def");
            phoneNum.put('4', "ghi");
            phoneNum.put('5', "jkl");
            phoneNum.put('6', "mno");
            phoneNum.put('7', "pqrs");
            phoneNum.put('8', "tuv");
            phoneNum.put('9', "wxyz");
            backTracking(phoneNum, digits, 0, new StringBuilder(), res);
            return res;
        }

        private void backTracking(Map<Character, String> phoneNum, String digits , Integer index,  StringBuilder sb , List<String> res) {
            // 收集到一组
            if (sb.length() == digits.length()) {
                res.add(sb.toString());
                return;
            }

            char c = digits.charAt(index);
            String str = phoneNum.get(c);
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                sb.append(charArray[i]);
                backTracking(phoneNum, digits, index + 1, sb, res);
                sb.deleteCharAt(index);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
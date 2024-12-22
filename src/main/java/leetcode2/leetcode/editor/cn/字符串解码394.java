//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics栈 | 递归 | 字符串 
//
// 👍 1843, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 394:字符串解码
 */
public class 字符串解码394 {
    public static void main(String[] args) {
        Solution solution = new 字符串解码394().new Solution();
        solution.decodeString("3[a]2[bc]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int index = 0;

        public String decodeString(String s) {
            Stack<String> stack = new Stack<>();
            char[] charArray = s.toCharArray();

            while (index < s.length()) {
                char c = charArray[index];
                // 如果是数字,直接压入栈内
                if (Character.isDigit(c)) {
                    String digit = getDigit(charArray);
                    stack.push(digit);
                } else if (c == '[' || Character.isLetter(c)) {
                    // 如果是左括号或字母，直接压入栈内
                    stack.push(String.valueOf(c));
                    index++;
                } else {
                    // 当遇到右括号时，栈往回找，一直找到左括号,拼装其中的字符串
                    List<String> list = new ArrayList<>();
                    while (!stack.isEmpty() && !stack.peek().equals("[")) {
                        list.add(stack.pop());
                    }
                    // 反转list，得到正序的字符串
                    Collections.reverse(list);
                    String str = toString(list);

                    // 把左括号弹出
                    stack.pop();
                    // 栈顶元素为数字
                    Integer count = Integer.valueOf(stack.pop());
                    // 根据重复次数构建字符串
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < count; i++) {
                        sb.append(str);
                    }
                    stack.push(sb.toString());
                    index++;

                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }

        // 因为数字可能有1位或者2位，这里需要拼一下数字
        private String getDigit(char[] charArray) {
            StringBuilder sb = new StringBuilder();
            while (Character.isDigit(charArray[index])) {
                sb.append(charArray[index]);
                index++;
            }
            return sb.toString();
        }

        private String toString(List<String> list) {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
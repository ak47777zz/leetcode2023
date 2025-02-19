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
// 👍 1906, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode4.leetcode.editor.cn;

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
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        // 使用单栈
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            // 如果是数字，直接入栈
            if (Character.isDigit(c)) {
                // 解码数字，兼容双数的情况
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(c)) {
                    sb.append(c);
                    index++;
                    c = s.charAt(index);
                }
                stack.push(sb.toString());
            } else if (c == '[' || Character.isLetter(c)) {
                // 如果是左括号或字符，直接入栈
                stack.push(String.valueOf(c));
                index++;
            } else {
                // 如果是右括号,拼接括号内的字符
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }

                // 把左括号弹出
                stack.pop();
                // 再弹出就是数字
                String num = stack.pop();
                StringBuilder sb1 = new StringBuilder();
                for (int i = 0; i < Integer.parseInt(num); i++) {
                    sb1.append(sb);
                }
                stack.push(sb1.toString());
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
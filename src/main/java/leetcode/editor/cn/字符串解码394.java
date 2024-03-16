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
// 👍 1696, 👎 0 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.net.http.WebSocketHandshakeException;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.Stack;

  /**
   * 394:字符串解码
   */
  public class 字符串解码394 {
      public static void main(String[] args) {
           Solution solution = new 字符串解码394().new Solution();
          String s = solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int index = 0;
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        while (index < s.length()) {
            char c = s.charAt(index);
            // 当遇到数字时,构建数字字符串
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(index))){
                    sb.append(s.charAt(index++));
                }
                stack.add(sb.toString());
            }
            // 当遇到字符或左括号时,直接入栈
            else if (Character.isLetter(c) || '[' == c) {
                stack.push(String.valueOf(c));
                index++;
            }
            // 遇到右括号时
            else {
                index++;
                List<String> list = new ArrayList<>();
                while (!stack.peek().equals("[")) {
                    list.add(stack.pop());
                }
                StringBuilder word = new StringBuilder();
                for (int i = list.size() - 1 ; i >= 0 ; i--) {
                    word.append(list.get(i));
                }

                // 遇到左括号了,出栈
                stack.pop();
                // 此时栈顶为数字
                int count = Integer.parseInt(stack.pop());
                // 根据次数构建最终字符串
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb.append(word);
                }
                stack.push(sb.toString());
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